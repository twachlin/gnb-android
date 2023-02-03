package com.gnb_android.home.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gnb_android.commons.data.repository.currency.CurrencyRepository
import com.gnb_android.commons.data.repository.currency.model.CurrencyConversion
import com.gnb_android.commons.ui.viewmodel.states.Loading
import com.gnb_android.commons.ui.viewmodel.states.UiState
import com.gnb_android.commons.ui.viewmodel.states.extensions.mapToUiState
import com.gnb_android.home.data.repository.transactions.TransactionsRepository
import com.gnb_android.home.data.repository.transactions.model.TransactionsBySku
import kotlinx.coroutines.launch

class HomeViewModel(
    private val currencyRepository: CurrencyRepository,
    private val transactionsRepository: TransactionsRepository
) : ViewModel() {

    val transactionsObservable: MutableLiveData<UiState<List<TransactionsBySku>>> = MutableLiveData()

    fun getTransactions() {
        viewModelScope.launch {
            transactionsObservable.postValue(Loading())
            transactionsObservable.postValue(
                transactionsRepository.getTransactions().mapToUiState()
            )
        }
    }
}