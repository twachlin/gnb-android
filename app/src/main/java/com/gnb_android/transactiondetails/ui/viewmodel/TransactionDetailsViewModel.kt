package com.gnb_android.transactiondetails.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gnb_android.commons.data.repository.currency.CurrencyRepository
import com.gnb_android.commons.data.repository.currency.model.CurrencyConversion
import com.gnb_android.commons.data.repository.currency.model.CurrencyType
import com.gnb_android.commons.data.repository.currency.model.CurrencyType.EUR
import com.gnb_android.commons.ui.viewmodel.states.Loading
import com.gnb_android.commons.ui.viewmodel.states.UiState
import com.gnb_android.commons.ui.viewmodel.states.extensions.mapToUiState
import com.gnb_android.home.data.repository.transactions.model.TransactionDetail
import java.math.BigDecimal
import java.math.RoundingMode.HALF_EVEN
import kotlinx.coroutines.launch

class TransactionDetailsViewModel(private val repository: CurrencyRepository) : ViewModel() {

    val currencyObservable: MutableLiveData<UiState<List<CurrencyConversion>>> = MutableLiveData()

    fun getCurrencyRates() {
        viewModelScope.launch {
            currencyObservable.postValue(Loading)
            currencyObservable.postValue(
                repository.getCurrencyRates().mapToUiState()
            )
        }
    }

    fun getTransactionsTotalAmount(
        currenciesConversions: List<CurrencyConversion>,
        transactions: List<TransactionDetail>
    ): BigDecimal {
        var totalAmount = BigDecimal("0")
        for (transaction in transactions) {
            with(transaction) {
                totalAmount += if (currency == EUR) {
                    amount
                } else {
                    convertToEUR(
                        amount,
                        from = currency,
                        conversions = currenciesConversions
                    )
                }
            }
        }
        return totalAmount.setScale(2, HALF_EVEN)
    }

    fun convertToEUR(
        amount: BigDecimal,
        from: CurrencyType,
        conversions: List<CurrencyConversion>
    ): BigDecimal {
        val directConversion = conversions.find { it.from == from && it.to == EUR }
        if (directConversion != null) {
            return convertCurrency(amount, directConversion.rate)
        }
        for (conversion in conversions) {
            if (conversion.from == from) {
                val intermediateAmount = convertCurrency(amount, conversion.rate)
                val intermediateResult =
                    convertToEUR(intermediateAmount, conversion.to, conversions)
                if (intermediateResult != intermediateAmount) {
                    return intermediateResult
                }
            }
        }
        return amount
    }

    /**
     * Convert to the specified currency passing amount to convert and rate of conversion
     * Return a BigDecimal with scale 2 and rounding mode HALF_EVEN (bankers rounding mode)
     */
    private fun convertCurrency(amount: BigDecimal, rate: BigDecimal): BigDecimal {
        return (amount * rate).setScale(2, HALF_EVEN)
    }
}