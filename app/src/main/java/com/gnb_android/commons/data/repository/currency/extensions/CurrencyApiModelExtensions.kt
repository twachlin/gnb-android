package com.gnb_android.commons.data.repository.currency.extensions

import com.gnb_android.commons.data.datasource.currency.model.CurrencyConversionApiModel
import com.gnb_android.commons.data.datasource.currency.model.CurrencyTypeApiModel
import com.gnb_android.commons.data.repository.currency.model.CurrencyConversion
import com.gnb_android.commons.data.repository.currency.model.CurrencyType
import java.math.RoundingMode.HALF_EVEN

fun CurrencyConversionApiModel.convertToCurrencyConversion(): CurrencyConversion =
    CurrencyConversion(
        from = from.convertToCurrencyType(),
        to = to.convertToCurrencyType(),
        rate = rate.setScale(4, HALF_EVEN)
    )

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