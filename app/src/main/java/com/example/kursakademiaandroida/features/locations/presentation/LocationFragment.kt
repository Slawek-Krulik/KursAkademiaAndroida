package com.example.kursakademiaandroida.features.locations.presentation

import android.util.Log
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

    override fun initViews() {
        super.initViews()

    }

    override fun initObservers() {
        super.initObservers()
        observerLocations()
    }

    override fun onIdleState() {
        super.onIdleState()
        //handle idle statue here
    }

    override fun onPendingState() {
        super.onPendingState()
        //handle pending statue here
    }

    private fun observerLocations() {
        viewModel.locations.observe(this) {
            Log.d("TAG", "observerLocations: $it")
        }
    }
}