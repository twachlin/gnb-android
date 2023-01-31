package com.gnb_android.home.data.repository.transactions

import com.gnb_android.commons.data.repository.states.DataState
import com.gnb_android.commons.data.repository.states.extensions.mapToDataState
import com.gnb_android.home.data.datasource.transactions.ITransactionsDataSource
import com.gnb_android.home.data.repository.transactions.extensions.convertToTransaction
import com.gnb_android.home.data.repository.transactions.model.Transaction

class TransactionsRepository(private val dataSource: ITransactionsDataSource) {

    fun getTransactions(): DataState<List<Transaction>>  {
        return dataSource.getTransactions().mapToDataState {
            it.map { transactionApiModel ->
                transactionApiModel.convertToTransaction()
            }
        }
    }
}