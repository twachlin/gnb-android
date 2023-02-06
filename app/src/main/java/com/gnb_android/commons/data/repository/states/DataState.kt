package com.gnb_android.commons.data.repository.states

/**
 * This class is used as State at Repository level
 */
sealed class DataState<out Data>

object EmptyDataState: DataState<Nothing>()

data class SuccessDataState<Data>(val body: Data) : DataState<Data>()

object BusinessErrorDataState : DataState<Nothing>()

object ErrorDataState : DataState<Nothing>()

