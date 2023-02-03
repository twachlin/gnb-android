package com.gnb_android.commons.data.repository.currency

import com.gnb_android.commons.data.datasource.currency.CurrencyRemoteDataSource
import com.gnb_android.commons.data.repository.currency.extensions.convertToCurrencyConversion
import com.gnb_android.commons.data.repository.currency.model.CurrencyConversion
import com.gnb_android.commons.data.repository.states.DataState
import com.gnb_android.commons.data.repository.states.extensions.mapToDataState

class CurrencyRepository(private val dataSource: CurrencyRemoteDataSource) {

    suspend fun getCurrencyRates(): DataState<List<CurrencyConversion>> {
        return dataSource.getCurrencyRates().mapToDataState { list ->
            list.map { currencyConversionApiModel ->
                currencyConversionApiModel.convertToCurrencyConversion()
            }
        }
    }
}