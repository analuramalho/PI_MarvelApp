package com.example.marvelapp.series.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.series.model.SeriesModel
import com.example.marvelapp.series.repository.SeriesRepository
import com.example.marvelapp.series.viewmodel.SeriesViewModel

class SeriesListFragment : Fragment() {
    private lateinit var _viewModel: SeriesViewModel
    private lateinit var _view:View
    private lateinit var _listAdapter: SeriesListAdapter

    private var _series = mutableListOf<SeriesModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_series_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _view = view

        val list = _view.findViewById<RecyclerView>(R.id.listSeries)
        val manager = GridLayoutManager(_view.context, 2)
        _series = mutableListOf<SeriesModel>()
        _listAdapter = SeriesListAdapter(_series) {

        }

        list.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _listAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            SeriesViewModel.SeriesViewModelFactory(SeriesRepository())
        ).get(SeriesViewModel::class.java)

        _viewModel.getList().observe(viewLifecycleOwner, Observer {
            showResults(it)
        })
        showLoading(true)
    }

    private fun showResults(list: List<SeriesModel>?) {
        showLoading(false)
        list?.isNotEmpty()?.let { notFound(it) }
        _series.clear()
        list?.let { _series.addAll(it) }
        _listAdapter.notifyDataSetChanged()
    }

    private fun showLoading(isLoading: Boolean) {
        val viewLoading = _view.findViewById<View>(R.id.seriesLoading)

        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

    private fun notFound(notFound: Boolean) {
        if (notFound) {
            _view.findViewById<View>(R.id.notFoundLayout).visibility = View.GONE
        } else {
            _view.findViewById<View>(R.id.notFoundLayout).visibility = View.VISIBLE
        }
    }
}