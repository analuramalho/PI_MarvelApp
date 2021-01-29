package com.marvelapp06.marvelapp.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.marvelapp06.marvelapp.favorite.entity.FavoriteEntity
import com.marvelapp06.marvelapp.favorite.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers

class FavoriteViewModel(private val repository: FavoriteRepository) : ViewModel() {

    fun addFavorite(modelId: Int, favorite: String, category: Int) = liveData(Dispatchers.IO) {
        val f = FavoriteEntity(0, modelId, favorite, category)
        repository.addFavorite(FavoriteEntity(0, modelId, favorite, category))
        emit(f)
    }

    fun getFavoritesCharacters() = liveData(Dispatchers.IO) {
        emit(repository.getFavoritesCharacters())
    }

    fun getFavoritesSeries() = liveData(Dispatchers.IO) {
        emit(repository.getFavoritesSeries())
    }

    fun getFavoritesComics() = liveData(Dispatchers.IO) {
        emit(repository.getFavoritesComics())
    }

    fun getFavoritesCreators() = liveData(Dispatchers.IO) {
        emit(repository.getFavoritesCreators())
    }


    fun deleteFavorite(modelId: Int) = liveData(Dispatchers.IO) {
        repository.deleteFavorite(modelId)
        emit(true)
    }

    fun checkIfIsFavorite(modelId: Int) = liveData(Dispatchers.IO) {
        emit(repository.checkIfIsFavorite(modelId))
    }

    class FavoriteViewModelFactory(private val repository: FavoriteRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return FavoriteViewModel(repository) as T
        }
    }
}