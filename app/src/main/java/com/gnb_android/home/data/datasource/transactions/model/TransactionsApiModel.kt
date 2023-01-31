package com.gnb_android.home.data.datasource.transactions.model

import com.gnb_android.commons.data.datasource.currency.model.CurrencyTypeApiModel
import java.math.BigDecimal

data class TransactionApiModel(
    val sku: String,
    val amount: BigDecimal,
    val currency: CurrencyTypeApiModel
)
