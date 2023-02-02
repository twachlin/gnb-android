package com.gnb_android.commons.data.datasource.currency

import com.gnb_android.BuildConfig.BASE_URL
import com.gnb_android.commons.data.datasource.currency.api.CurrencyApi
import com.gnb_android.commons.data.datasource.currency.model.CurrencyConversionsApiModel
import com.gnb_android.commons.data.datasource.response.ApiResponse
import com.gnb_android.commons.data.datasource.response.extensions.mapToApiResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrencyRemoteDataSource() : ICurrencyDataSource {

    private val api: CurrencyApi = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(CurrencyApi::class.java)

    override suspend fun getCurrencyRates(): ApiResponse<CurrencyConversionsApiModel> {
        return api.getCurrencyRates().mapToApiResponse()
    }

}