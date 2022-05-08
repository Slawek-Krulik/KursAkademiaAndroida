package com.example.kursakademiaandroida.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}