package com.example.kursakademiaandroida.features.characters.presentation

import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_characters) {
    override val viewModel: CharacterViewModel by viewModel()

    override fun initViews() {
        super.initViews()

    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }


    override fun onIdleState() {
        super.onIdleState()
        //handle idle status here
    }

    override fun onPendingState() {
        super.onPendingState()
        //handle pending status here
    }

    private fun observeCharacters() {
        viewModel.character.observe(this) {
            //code to display characters
        }
    }

}