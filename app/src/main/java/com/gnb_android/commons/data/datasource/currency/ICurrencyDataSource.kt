package com.gnb_android.commons.data.datasource.currency

import com.gnb_android.commons.data.datasource.currency.model.CurrencyConversionApiModel
import com.gnb_android.commons.data.datasource.response.ApiResponse

interface ICurrencyDataSource {
    suspend fun getCurrencyRates(): ApiResponse<List<CurrencyConversionApiModel>>
}