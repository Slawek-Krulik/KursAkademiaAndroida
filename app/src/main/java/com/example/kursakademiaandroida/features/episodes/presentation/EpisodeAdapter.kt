package com.example.kursakademiaandroida.features.episodes.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeAdapter :
    ListAdapter<EpisodeDisplayable, EpisodeAdapter.ViewHolder>(EpisodeDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_episode_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object EpisodeDiffCallback : DiffUtil.ItemCallback<EpisodeDisplayable>() {
        override fun areItemsTheSame(
            oldItem: EpisodeDisplayable,
            newItem: EpisodeDisplayable
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EpisodeDisplayable,
            newItem: EpisodeDisplayable
        ): Boolean {
            return oldItem.id == newItem.id && oldItem.airDate == newItem.airDate && oldItem.code == newItem.code && oldItem.url == newItem.url && oldItem.name == newItem.name
        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.episode_name)
        private val code: TextView = view.findViewById(R.id.episode_code)
        private val airDate: TextView = view.findViewById(R.id.episode_air_date)

        fun bind(episode: EpisodeDisplayable) {
            name.text = episode.name
            code.text = episode.code
            airDate.text = episode.airDate
        }

    }


}