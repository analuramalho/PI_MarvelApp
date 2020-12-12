package com.marvelapp06.marvelapp.favorite.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marvelapp06.marvelapp.R
import com.marvelapp06.marvelapp.favorite.model.SeriesFavoriteModel

class SeriesFavoriteAdapter(
    private val _dataset: List<SeriesFavoriteModel>,
    private val _clickListener: (SeriesFavoriteModel) -> Unit
) : RecyclerView.Adapter<SeriesFavoriteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesFavoriteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_series_list_item, parent, false)

        return SeriesFavoriteViewHolder(view)
    }

    override fun getItemCount() = _dataset.size

    override fun onBindViewHolder(holder: SeriesFavoriteViewHolder, position: Int) {
        val dSPosition = _dataset[position]
        holder.bind(dSPosition)
        holder.itemView.setOnClickListener { _clickListener(dSPosition) }
    }
}