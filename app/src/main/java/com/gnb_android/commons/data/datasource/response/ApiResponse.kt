package com.gnb_android.commons.data.datasource.response

/**
 * This is a common class used by API responses
 */
sealed class ApiResponse<out Data>

data class SuccessApiResponse<out Data>(val body: Data) : ApiResponse<Data>()

object EmptyApiResponse : ApiResponse<Nothing>()

object BusinessErrorApiResponse : ApiResponse<Nothing>()