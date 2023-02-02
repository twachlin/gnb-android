package com.gnb_android.home.data.repository.transactions.extensions

import com.gnb_android.commons.data.repository.currency.extensions.convertToCurrencyType
import com.gnb_android.home.data.datasource.transactions.model.TransactionApiModel
import com.gnb_android.home.data.repository.transactions.model.TransactionDetail

fun TransactionApiModel.convertToTransaction(): TransactionDetail =
    TransactionDetail(
        sku = sku,
        amount = amount,
        currency = currency.convertToCurrencyType()
    )