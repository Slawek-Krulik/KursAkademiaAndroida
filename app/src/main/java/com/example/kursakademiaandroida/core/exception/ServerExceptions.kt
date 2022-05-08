package com.example.kursakademiaandroida.core.exception

sealed class ServerExceptions(message: String?) : Throwable(message) {
    class Internal(message: String?) : ServerExceptions(message)
    class BadRequest(message: String?) : ServerExceptions(message)
    class Unknown(message: String?) : ServerExceptions(message)
}