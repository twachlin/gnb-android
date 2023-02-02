package com.gnb_android.home.data.repository.transactions.model

import com.gnb_android.commons.data.repository.currency.model.CurrencyType
import java.math.BigDecimal

data class TransactionsBySku(
    val sku: String,
    val transactionDetail: List<TransactionDetail>
)
data class TransactionDetail (
    val sku: String,
    val amount: BigDecimal,
    val currency: CurrencyType
)