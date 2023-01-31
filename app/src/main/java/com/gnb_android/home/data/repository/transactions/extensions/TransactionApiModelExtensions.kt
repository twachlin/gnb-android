package com.gnb_android.home.data.repository.transactions.extensions

import com.gnb_android.commons.data.datasource.currency.model.CurrencyTypeApiModel
import com.gnb_android.commons.data.repository.currency.model.CurrencyType
import com.gnb_android.home.data.datasource.transactions.model.TransactionApiModel
import com.gnb_android.home.data.repository.transactions.model.Transaction

fun TransactionApiModel.convertToTransaction(): Transaction =
    Transaction(
        sku = sku,
        amount = amount,
        currency = currency.convertToCurrencyType()
    )

// Todo: Delete this function. It must be in a file of CurrencyExtensions
fun CurrencyTypeApiModel.convertToCurrencyType(): CurrencyType {
    return when (this) {
        CurrencyTypeApiModel.EUR -> CurrencyType.EUR
        CurrencyTypeApiModel.USD -> CurrencyType.USD
        CurrencyTypeApiModel.CAD -> CurrencyType.CAD
        CurrencyTypeApiModel.GBP -> CurrencyType.GBP
        CurrencyTypeApiModel.JPY -> CurrencyType.JPY
        CurrencyTypeApiModel.AUD -> CurrencyType.AUD
        CurrencyTypeApiModel.SEK -> CurrencyType.SEK
        CurrencyTypeApiModel.RUB -> CurrencyType.RUB
        CurrencyTypeApiModel.INR -> CurrencyType.INR
    }
}