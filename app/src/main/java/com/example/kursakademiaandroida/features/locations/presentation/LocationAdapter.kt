package com.example.kursakademiaandroida.features.locations.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kursakademiaandroida.R
import com.example.kursakademiaandroida.features.locations.presentation.model.LocationDisplayable

class LocationAdapter :
    ListAdapter<LocationDisplayable, LocationAdapter.ViewHolder>(LocationDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_location_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object LocationDiffCallback : DiffUtil.ItemCallback<LocationDisplayable>() {
        override fun areItemsTheSame(
            oldItem: LocationDisplayable,
            newItem: LocationDisplayable
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LocationDisplayable,
            newItem: LocationDisplayable
        ): Boolean {
            return oldItem.id == newItem.id && oldItem.dimension == newItem.dimension && oldItem.name == newItem.name && oldItem.type == newItem.type && oldItem.url == newItem.url && oldItem.residents == newItem.residents
        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name: TextView = view.findViewById(R.id.location_name)
        private val dimension: TextView = view.findViewById(R.id.location_dimension)
        private val type: TextView = view.findViewById(R.id.location_type)

        fun bind(item: LocationDisplayable) {
            name.text = "Name: ${item.name}"
            dimension.text = "Dimen: ${item.dimension}"
            type.text = "Type: ${item.type}"
        }
    }


}