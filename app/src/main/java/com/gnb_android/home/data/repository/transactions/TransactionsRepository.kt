package com.gnb_android.home.data.repository.transactions

import com.gnb_android.commons.data.repository.states.DataState
import com.gnb_android.commons.data.repository.states.extensions.mapToDataState
import com.gnb_android.home.data.datasource.transactions.ITransactionsDataSource
import com.gnb_android.home.data.datasource.transactions.model.TransactionApiModel
import com.gnb_android.home.data.repository.transactions.extensions.convertToTransaction
import com.gnb_android.home.data.repository.transactions.model.TransactionsBySku

class TransactionsRepository(private val dataSource: ITransactionsDataSource) {

    fun getTransactions(): DataState<List<TransactionsBySku>> {
        return dataSource.getTransactions().mapToDataState {
            it.convertToTransactionsGroupedLists()
        }
    }

    /**
     * Group transactions by sku value and return a list of TransactionsBySku.
     */
    private fun List<TransactionApiModel>.convertToTransactionsGroupedLists(): List<TransactionsBySku> {
        val transactionsBySku = this.groupBy { it.sku }
        return transactionsBySku.map {
            TransactionsBySku(it.key, it.value.map { transactionApiModel ->
                transactionApiModel.convertToTransaction() })
        }
    }
}