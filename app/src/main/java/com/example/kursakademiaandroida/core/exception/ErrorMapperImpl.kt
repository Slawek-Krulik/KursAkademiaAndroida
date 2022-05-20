package com.example.kursakademiaandroida.core.exception

import android.content.Context
import androidx.annotation.StringRes
import com.example.kursakademiaandroida.R

class ErrorMapperImpl(private val context: Context) : ErrorMapper {
    override fun map(throwable: Throwable): String {
        return when (throwable) {
            is ServerExceptions -> mapServerException(throwable)
            else -> getMessage(R.string.error_unknown)
        }
    }

    private fun mapServerException(serverException: ServerExceptions): String {
        return when (serverException) {
            is ServerExceptions.BadRequest -> getMessage(R.string.error_bad_request)
            is ServerExceptions.Internal -> getMessage(R.string.error_internal)
            else -> getMessage(R.string.error_unknown)
        }
    }

    private fun getMessage(@StringRes stringRes: Int) = context.getString(stringRes)
}