package com.gnb_android.home.data.datasource.transactions.api

import com.gnb_android.home.data.datasource.transactions.model.TransactionApiModel
import retrofit2.Response
import retrofit2.http.GET

interface TransactionsApi {

    @GET("transactions")
    fun getTransactions(): Response<List<TransactionApiModel>>

}