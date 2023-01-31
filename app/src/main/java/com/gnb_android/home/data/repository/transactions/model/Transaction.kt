package com.gnb_android.home.data.repository.transactions.model

import com.gnb_android.commons.data.repository.currency.model.CurrencyType
import java.math.BigDecimal

data class Transaction (
    val sku: String,
    val amount: BigDecimal,
    val currency: CurrencyType
)