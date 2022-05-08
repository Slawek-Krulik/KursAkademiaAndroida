package com.example.kursakademiaandroida.core.exception

sealed class ServerExceptions(message: String?) : Throwable(message) {
    class Internal(message: String?) : Throwable(message)
    class BadRequest(message: String?) : Throwable(message)
    class Unknown(message: String?) : Throwable(message)
}