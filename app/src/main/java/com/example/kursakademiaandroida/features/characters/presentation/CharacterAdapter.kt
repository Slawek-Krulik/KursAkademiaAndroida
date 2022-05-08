package com.example.kursakademiaandroida.features.characters.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable

class CharacterAdapter :
    ListAdapter<CharacterDisplayable, CharacterAdapter.ViewHolder>(CharacterDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_character_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object CharacterDiffCallback : DiffUtil.ItemCallback<CharacterDisplayable>() {
        override fun areItemsTheSame(
            oldItem: CharacterDisplayable,
            newItem: CharacterDisplayable
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterDisplayable,
            newItem: CharacterDisplayable
        ): Boolean {
            return oldItem.id == newItem.id && oldItem.name == newItem.name && oldItem.gender == newItem.gender && oldItem.status == newItem.status && oldItem.species == newItem.species
        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.character_name)
        private val gender: TextView = view.findViewById(R.id.character_gender)
        private val status: TextView = view.findViewById(R.id.character_status)
        private val species: TextView = view.findViewById(R.id.character_species)

        fun bind(item: CharacterDisplayable) {
            name.text = "Name ${item.name}"
            gender.text = "Gender: ${item.gender}"
            status.text = "Status: ${item.status}"
            species.text = "Species: ${item.species}"
        }

    }

}