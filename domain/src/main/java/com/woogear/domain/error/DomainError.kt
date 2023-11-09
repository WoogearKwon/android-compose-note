package com.woogear.domain.error

class DomainError(
    errorCode: ErrorCode = ErrorCode.UNKNOWN_ERROR,
    message: String? = null,
    cause: Throwable? = null
) : Exception(message, cause)