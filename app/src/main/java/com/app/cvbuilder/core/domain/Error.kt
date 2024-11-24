package com.app.cvbuilder.core.domain

sealed interface Error

sealed interface DataError : Error {
    enum class Network : DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        PAYLOAD_TOO_LARGE,
        SERVER_ERROR,
        UNKNOWN
    }

    enum class Local : DataError {
        DISK_FULL,
        UNKNOWN
    }
}
