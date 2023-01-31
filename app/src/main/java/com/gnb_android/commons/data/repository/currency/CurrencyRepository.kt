package com.gnb_android.commons.data.repository.currency

import com.gnb_android.commons.data.datasource.currency.CurrencyRemoteDataSource
import com.gnb_android.commons.data.repository.currency.extensions.convertToCurrencyConversions
import com.gnb_android.commons.data.repository.currency.model.CurrencyConversions
import com.gnb_android.commons.data.repository.states.DataState
import com.gnb_android.commons.data.repository.states.extensions.mapToDataState

class CurrencyRepository(private val dataSource: CurrencyRemoteDataSource) {

    suspend fun getCurrencyRates(): DataState<CurrencyConversions> {
        return dataSource.getCurrencyRates().mapToDataState {
            it.convertToCurrencyConversions()
        }
    }
}