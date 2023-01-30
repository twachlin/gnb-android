package com.gnb_android.commons.data.datasource.currency.api

import com.gnb_android.commons.data.datasource.currency.model.CurrencyConversionsApiModel
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApi {

    /**
     * This method return a list with currency rates.
     * EUR -> USD
     * USD -> EUR
     * GBP -> EUR
     * JPY -> USD
     * AUD -> INR
     * CAD -> USD
     * SEK -> USD
     * RUB -> SEK
     * INR -> EUR
     */
    @GET("rates")
    fun getCurrencyRates(): Response<CurrencyConversionsApiModel>

}