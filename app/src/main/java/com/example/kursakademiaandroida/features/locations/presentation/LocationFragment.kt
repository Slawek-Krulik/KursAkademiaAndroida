package com.example.kursakademiaandroida.features.locations.presentation

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

    private val adapterLocation = LocationAdapter()

    override fun initViews() {
        super.initViews()

        val recyclerView = view?.findViewById<RecyclerView>(R.id.location_recycler)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterLocation
        }
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
            adapterLocation.submitList(ArrayList(it))
        }
    }
}