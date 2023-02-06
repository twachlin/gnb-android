package com.gnb_android.home.data.datasource.transactions

import com.gnb_android.commons.data.datasource.BaseRemoteDataSource
import com.gnb_android.commons.data.datasource.response.ApiResponse
import com.gnb_android.core.connectivity.RetrofitFactory
import com.gnb_android.home.data.datasource.transactions.api.TransactionsApi
import com.gnb_android.home.data.datasource.transactions.model.TransactionApiModel

class TransactionsRemoteDataSource : ITransactionsDataSource, BaseRemoteDataSource() {

    private val api: TransactionsApi by lazy {
        RetrofitFactory.getRetrofitService(TransactionsApi::class.java)
    }

    override suspend fun getTransactions(): ApiResponse<List<TransactionApiModel>> {
        return request(getApiService = { api.getTransactions() })
    }
}