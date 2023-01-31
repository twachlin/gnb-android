package com.gnb_android.home.data.datasource.transactions

import com.gnb_android.commons.data.datasource.response.ApiResponse
import com.gnb_android.home.data.datasource.transactions.model.TransactionApiModel

interface ITransactionsDataSource {

    fun getTransactions(): ApiResponse<List<TransactionApiModel>>
}