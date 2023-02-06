package com.gnb_android.transactiondetails.ui

import com.gnb_android.commons.data.repository.currency.CurrencyRepository
import com.gnb_android.commons.data.repository.currency.model.CurrencyConversion
import com.gnb_android.commons.data.repository.currency.model.CurrencyType.EUR
import com.gnb_android.commons.data.repository.currency.model.CurrencyType.JPY
import com.gnb_android.commons.data.repository.currency.model.CurrencyType.USD
import com.gnb_android.home.data.repository.transactions.model.TransactionDetail
import com.gnb_android.transactiondetails.ui.viewmodel.TransactionDetailsViewModel
import io.mockk.mockk
import java.math.BigDecimal
import org.junit.Assert
import org.junit.Test

class TransactionDetailsViewModelTest {

    private val repository = mockk<CurrencyRepository>()
    private val viewModel = TransactionDetailsViewModel(repository)
    private val currenciesConversions = listOf(
        CurrencyConversion(from = USD, to = EUR, rate = BigDecimal("0.96")),
        CurrencyConversion(from = EUR, to = USD, rate = BigDecimal("1.04")),
        CurrencyConversion(from = JPY, to = USD, rate = BigDecimal("0.0073"))
    )

    @Test
    fun `test getTransactionsTotalAmount`() {

        val transactions = listOf(
            TransactionDetail("T2006", BigDecimal("100"), EUR),
            TransactionDetail("T2006", BigDecimal("200"), USD),
            TransactionDetail("T2006", BigDecimal("300"), USD)
        )

        val result = viewModel.getTransactionsTotalAmount(currenciesConversions, transactions)
        Assert.assertEquals(BigDecimal("580.00"), result)
    }

    @Test
    fun `test convertToEUR`() {
        val result = viewModel.convertToEUR(BigDecimal("100"), USD, currenciesConversions)
        Assert.assertEquals(BigDecimal("96.00"), result)
    }
}