package com.marvelapp06.marvelapp.series.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marvelapp06.marvelapp.R
import com.marvelapp06.marvelapp.series.model.SeriesModel
import com.squareup.picasso.Picasso

class SeriesListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    private val _name = view.findViewById<TextView>(R.id.txtSeriesName)
    private val _image = view.findViewById<ImageView>(R.id.imgSeries)

    fun bind(seriesModel: SeriesModel) {
        _name.text = seriesModel.title
        Picasso.get().load(seriesModel.thumbnail?.getImagePath()).into(_image)
    }
}