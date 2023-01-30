package com.gnb_android.commons.data.repository.currency

import com.gnb_android.commons.data.datasource.currency.CurrencyRemoteDataSource
import com.gnb_android.commons.data.datasource.currency.model.CurrencyConversionItemApiModel
import com.gnb_android.commons.data.datasource.currency.model.CurrencyConversionsApiModel
import com.gnb_android.commons.data.datasource.currency.model.CurrencyTypeApiModel
import com.gnb_android.commons.data.repository.currency.model.CurrencyConversionItem
import com.gnb_android.commons.data.repository.currency.model.CurrencyConversions
import com.gnb_android.commons.data.repository.currency.model.CurrencyType
import com.gnb_android.commons.data.repository.states.DataState
import com.gnb_android.commons.data.repository.states.extensions.mapToDataState

class CurrencyRepository(private val dataSource: CurrencyRemoteDataSource) {

    suspend fun getCurrencyRates(): DataState<CurrencyConversions> {
        return dataSource.getCurrencyRates().mapToDataState {
            it.convertToCurrencyConversions()
        }
    }

    private fun CurrencyConversionsApiModel.convertToCurrencyConversions(): CurrencyConversions =
        CurrencyConversions(
            this.conversion.map { it.convertToCurrencyConversionItem() }
        )

    private fun CurrencyConversionItemApiModel.convertToCurrencyConversionItem(): CurrencyConversionItem =
        CurrencyConversionItem(
            from = from.convertToCurrencyType(),
            to = to.convertToCurrencyType(),
            rate = rate
        )

    private fun CurrencyTypeApiModel.convertToCurrencyType(): CurrencyType {
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
}