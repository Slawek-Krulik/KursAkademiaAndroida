package com.example.kursakademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursakademiaandroida.core.exception.ErrorMapper
import com.example.kursakademiaandroida.core.exception.ErrorMapperImpl
import com.example.kursakademiaandroida.core.exception.ErrorWrapper
import com.example.kursakademiaandroida.core.exception.ErrorWrapperImpl
import com.example.kursakademiaandroida.core.network.NetworkStateAvailableImpl
import com.example.kursakademiaandroida.core.network.NetworkStateProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    factory {
        LinearLayoutManager(androidContext())
    }

    factory {
        GridLayoutManager(androidContext(), 2)
    }

    factory {
        DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL)
    }

    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }

    factory<NetworkStateProvider> { NetworkStateAvailableImpl(get()) }

    factory<ErrorWrapper> { ErrorWrapperImpl() }

    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
}