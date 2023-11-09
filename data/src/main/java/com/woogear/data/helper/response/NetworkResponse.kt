package com.woogear.data.helper.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.IOException

sealed class NetworkResponse<out T : Any, out U : Any> {

    data class Success<T : Any>(
        val body: T,
    )  : NetworkResponse<T, Nothing>()

    /**
     * Failure response with body
     */
    data class ApiError<U : Any>(
        val body: U,
        val httpStatusCode: Int,
    ) : NetworkResponse<Nothing, U>()

    /**
     * Network error
     */
    data class NetworkError(
        val error: IOException
    ) : NetworkResponse<Nothing, Nothing>()

    /**
     * For example, json parsing error
     */
    data class UnknownError(
        val error: Throwable?
    ) : NetworkResponse<Nothing, Nothing>()
}

typealias ApiResponse<T> = NetworkResponse<T, ApiErrorBody>

@Serializable
data class ApiBody<out T : Any>(

    @SerialName("data")
    val data: T,
)

@Serializable
data class ApiErrorBody(
    @SerialName("code")
    val code: Int,

    @SerialName("message")
    val message: String? = null,
)
