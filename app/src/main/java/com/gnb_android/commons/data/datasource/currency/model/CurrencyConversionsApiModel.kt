package com.gnb_android.commons.data.datasource.currency.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.math.BigDecimal

@JsonClass(generateAdapter = true)
data class CurrencyConversionApiModel(
    @Json(name = "from")
    val from: CurrencyTypeApiModel,
    @Json(name = "to")
    val to: CurrencyTypeApiModel,
    @Json(name = "rate")
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