package com.marvelapp06.marvelapp.favorite.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.marvelapp06.marvelapp.R
import com.marvelapp06.marvelapp.character.model.CharactersModel
import com.marvelapp06.marvelapp.creator.model.CreatorsModel
import com.marvelapp06.marvelapp.db.AppDatabase
import com.marvelapp06.marvelapp.favorite.model.CreatorsFavoriteModel
import com.marvelapp06.marvelapp.favorite.repository.CreatorsFavoriteRepository
import com.marvelapp06.marvelapp.favorite.repository.FavoriteRepository
import com.marvelapp06.marvelapp.favorite.viewmodel.CreatorsFavoriteViewModel
import com.marvelapp06.marvelapp.favorite.viewmodel.FavoriteViewModel

class FavoriteCreatorFragment : Fragment() {
    private lateinit var _view:View
    private lateinit var _viewModelFavorite: FavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _view  = inflater.inflate(R.layout.fragment_favorite_comic, container, false)
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _viewModelFavorite = ViewModelProvider(
            this,
            FavoriteViewModel.FavoriteViewModelFactory(
                FavoriteRepository(
                    AppDatabase.getDatabase(
                        _view.context
                    ).favoriteDao()
                )
            )
        ).get(FavoriteViewModel::class.java)


        _viewModelFavorite.getFavoritesCreators().observe(viewLifecycleOwner, Observer { list ->
            val listCreators: MutableList<CreatorsModel> = mutableListOf()
            list.forEach {
                listCreators.add(jsonToObj(it.favorite))
            }
            getList(listCreators)
        })

    }

    private fun getList(list:List<CreatorsModel>){
        val viewManager= GridLayoutManager(_view.context,2)
        val recyclerView=_view.findViewById<RecyclerView>(R.id.listComicFavorites)
        val menuAdapter = CreatorsFavoriteAdapter(list){
            Toast.makeText(context, "clicado", Toast.LENGTH_SHORT).show()
        }

        recyclerView.apply {
            layoutManager=viewManager
            adapter=menuAdapter
        }
    }

    fun jsonToObj(json: String): CreatorsModel {
        val gson = Gson()
        return gson.fromJson(json, CreatorsModel::class.java)
    }

}