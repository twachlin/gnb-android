package com.gnb_android.commons.data.datasource.currency

import com.gnb_android.commons.data.datasource.currency.api.CurrencyApi
import com.gnb_android.commons.data.datasource.currency.model.CurrencyConversionApiModel
import com.gnb_android.commons.data.datasource.response.ApiResponse
import com.gnb_android.commons.data.datasource.response.extensions.mapToApiResponse
import com.gnb_android.core.connectivity.RetrofitFactory

class CurrencyRemoteDataSource() : ICurrencyDataSource {

    private val api: CurrencyApi by lazy {
        RetrofitFactory.getRetrofitService(CurrencyApi::class.java)
    }

    override suspend fun getCurrencyRates(): ApiResponse<List<CurrencyConversionApiModel>> {
        return api.getCurrencyRates().mapToApiResponse()
    }

}