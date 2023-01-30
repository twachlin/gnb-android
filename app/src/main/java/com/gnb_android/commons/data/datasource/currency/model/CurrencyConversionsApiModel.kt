package com.gnb_android.commons.data.datasource.currency.model

import com.google.gson.annotations.SerializedName
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
    @SerializedName("EUR")
    EUR,
    @SerializedName("USD")
    USD,
    @SerializedName("CAD")
    CAD,
    @SerializedName("GBP")
    GBP,
    @SerializedName("JPY")
    JPY,
    @SerializedName("AUD")
    AUD,
    @SerializedName("SEK")
    SEK,
    @SerializedName("RUB")
    RUB,
    @SerializedName("INR")
    INR
}