package com.gnb_android.commons.data.datasource.repository.states

sealed class DataState<out Data>

object EmptyDataState: DataState<Nothing>()

data class SuccessDataState<Data>(val body: Data) : DataState<Data>()

object BusinessErrorDataState : DataState<Nothing>()


