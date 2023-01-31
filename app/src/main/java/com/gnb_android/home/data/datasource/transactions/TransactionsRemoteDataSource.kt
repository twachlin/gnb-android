package com.gnb_android.home.data.datasource.transactions

import com.gnb_android.commons.data.datasource.response.ApiResponse
import com.gnb_android.commons.data.datasource.response.extensions.mapToApiResponse
import com.gnb_android.home.data.datasource.transactions.api.TransactionsApi
import com.gnb_android.home.data.datasource.transactions.model.TransactionApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TransactionsRemoteDataSource(): ITransactionsDataSource {

    private val BASE_URL = ""
    private val api: TransactionsApi = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(TransactionsApi::class.java)

    override fun getTransactions(): ApiResponse<List<TransactionApiModel>> {
        return api.getTransactions().mapToApiResponse()
    }
}