package com.gnb_android.commons.data.repository.currency.model

import java.math.BigDecimal

data class CurrencyConversions(
    val conversion: List<CurrencyConversionItem>
)

data class CurrencyConversionItem(
    val from: CurrencyType,
    val to: CurrencyType,
    val rate: BigDecimal
)

enum class CurrencyType {
    EUR,
    USD,
    CAD,
    GBP,
    JPY,
    AUD,
    SEK,
    RUB,
    INR
}