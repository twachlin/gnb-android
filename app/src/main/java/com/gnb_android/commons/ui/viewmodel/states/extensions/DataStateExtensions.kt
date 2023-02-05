package com.gnb_android.commons.ui.viewmodel.states.extensions

import com.gnb_android.commons.data.repository.states.BusinessErrorDataState
import com.gnb_android.commons.data.repository.states.DataState
import com.gnb_android.commons.data.repository.states.EmptyDataState
import com.gnb_android.commons.data.repository.states.ErrorDataState
import com.gnb_android.commons.data.repository.states.SuccessDataState
import com.gnb_android.commons.ui.viewmodel.states.BusinessError
import com.gnb_android.commons.ui.viewmodel.states.Empty
import com.gnb_android.commons.ui.viewmodel.states.NetworkError
import com.gnb_android.commons.ui.viewmodel.states.Success
import com.gnb_android.commons.ui.viewmodel.states.UiState

fun <Data> DataState<Data>.mapToUiState(): UiState<Data> {
    return when (this) {
        is EmptyDataState -> {
            Empty
        }
        is SuccessDataState -> {
            Success(this.body)
        }
        is BusinessErrorDataState -> {
            BusinessError
        }
        is ErrorDataState -> {
            NetworkError
        }
    }
}