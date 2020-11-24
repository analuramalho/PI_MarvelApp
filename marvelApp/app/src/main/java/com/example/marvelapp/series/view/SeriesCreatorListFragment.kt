package com.example.marvelapp.series.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.marvelapp.R
import com.example.marvelapp.data.model.CreatorsList

class SeriesCreatorListFragment : Fragment() {
    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_series_creator_list, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(creators: CreatorsList?) =
            SeriesCreatorListFragment().apply {
                arguments = Bundle().apply {
                    putString("SERIES_CREATORS", creators.toString())
                }
            }
    }
}