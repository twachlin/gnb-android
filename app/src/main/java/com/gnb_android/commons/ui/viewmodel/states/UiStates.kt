package com.gnb_android.commons.ui.viewmodel.states

/**
 * Possible UI states
 */
sealed class UiState<out Data>

/**
 * Loading
 */
class Loading(val isFinished: Boolean = false) : UiState<Nothing>()

/**
 * Success State
 */
sealed class SuccessUiState<out Data> : UiState<Data>()

object Empty : SuccessUiState<Nothing>()

class Success<out Data>(val body: Data) : SuccessUiState<Data>()

/**
 * Business Error State
 */
object BusinessError : UiState<Nothing>()

/**
 * Network error state
 */
object NetworkError : UiState<Nothing>()