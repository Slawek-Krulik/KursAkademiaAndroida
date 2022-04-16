package com.example.kursakademiaandroida.features.characters.presentation

import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_characters) {
    override val viewModel: CharacterViewModel by viewModel()

    private var characterAdapter = CharacterAdapter()
    private var progressBar: RelativeLayout? = null

    override fun initViews() {
        super.initViews()
        val recyclerView = view?.findViewById<RecyclerView>(R.id.character_recycler)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter
        }

        progressBar = view?.findViewById(R.id.character_progress_bar)
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }


    override fun onIdleState() {
        super.onIdleState()
        //handle idle status here
        progressBar?.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        //handle pending status here
        progressBar?.visibility = View.VISIBLE
    }

    private fun observeCharacters() {
        viewModel.character.observe(this) {
            //code to display characters
            characterAdapter.submitList(ArrayList(it))
        }
    }

}