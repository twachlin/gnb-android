package com.gnb_android.commons.data.datasource.response.extensions


import com.gnb_android.commons.data.datasource.response.*
import retrofit2.Response

/**
 * Convert a Retrofit response into an ApiResponse to allow states management
 */
fun <Data> Response<Data>.mapToApiResponse(): ApiResponse<Data> {
    return if (this.isSuccessful) {
        when (this.code()) {
            200 -> {
                this.body()?.let { data ->
                    SuccessApiResponse(data)
                } ?: run {
                    EmptyApiResponse
                }
            }
            else -> {
                EmptyApiResponse
            }
        }
    } else {
        BusinessErrorApiResponse
    }
}