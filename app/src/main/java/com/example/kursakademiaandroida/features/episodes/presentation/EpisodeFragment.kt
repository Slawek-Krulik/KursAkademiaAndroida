package com.example.kursakademiaandroida.features.episodes.presentation

import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()

    private var episodeAdapter = EpisodeAdapter()
    private var progressBar: RelativeLayout? = null

    override fun initViews() {
        super.initViews()
        //initialize all view-related classes
        val recyclerView = view?.findViewById<RecyclerView>(R.id.episode_recycler)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = episodeAdapter
        }

        progressBar = view?.findViewById(R.id.episode_progress_bar)
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        //handle idle statue here
        progressBar?.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        //handle pending statue here
        progressBar?.visibility = View.VISIBLE
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            //code to display episodes
            episodeAdapter?.submitList(ArrayList(it))
        }

    }

}