package com.gnb_android.commons.data.datasource.currency.model

import com.squareup.moshi.Json
import java.math.BigDecimal

data class CurrencyConversionsApiModel(
    val conversion: List<CurrencyConversionItemApiModel>
)

data class CurrencyConversionItemApiModel(
    val from: CurrencyTypeApiModel,
    val to: CurrencyTypeApiModel,
    val rate: BigDecimal
)

enum class CurrencyTypeApiModel {
    @Json(name = "EUR")
    EUR,

    @Json(name = "USD")
    USD,

    @Json(name = "CAD")
    CAD,

    @Json(name = "GBP")
    GBP,

    @Json(name = "JPY")
    JPY,

    @Json(name = "AUD")
    AUD,

    @Json(name = "SEK")
    SEK,

    @Json(name = "RUB")
    RUB,

    @Json(name = "INR")
    INR
}