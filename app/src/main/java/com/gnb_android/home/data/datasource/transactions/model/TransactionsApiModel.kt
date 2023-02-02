package com.gnb_android.home.data.datasource.transactions.model

import com.gnb_android.commons.data.datasource.currency.model.CurrencyTypeApiModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.math.BigDecimal

@JsonClass(generateAdapter = true)
data class TransactionApiModel(
    @Json(name = "sku")
    val sku: String,
    @Json(name = "amount")
    val amount: BigDecimal,
    @Json(name = "currency")
    val currency: CurrencyTypeApiModel
)
