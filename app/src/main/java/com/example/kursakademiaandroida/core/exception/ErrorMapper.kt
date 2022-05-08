package com.example.kursakademiaandroida.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}