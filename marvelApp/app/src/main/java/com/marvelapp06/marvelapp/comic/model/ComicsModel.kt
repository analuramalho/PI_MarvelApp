package com.marvelapp06.marvelapp.comic.model

import com.marvelapp06.marvelapp.data.model.CharactersList
import com.marvelapp06.marvelapp.data.model.CreatorsList
import com.marvelapp06.marvelapp.data.model.ThumbnailModel
import com.marvelapp06.marvelapp.data.model.UrlModel
import com.marvelapp06.marvelapp.series.model.SeriesSummaryModel
import java.util.*

class ComicsModel (
    val id: Int?,
    val digitalId: Int?,
    val title: String?,
    val issueNumber: Double?,
    val variantDescription: String?,
    val description: String?,
    val modified: Date?,
    val isbn: String?,
    val upc: String?,
    val diamondCode: String?,
    val ean: String?,
    val issn: String?,
    val format: String?,
    val pageCount: Int?,
    val textObjects: List<TextObjectModel>?,
    val resoucerURI: String?,
    val urls: List<UrlModel>?,
    val series: SeriesSummaryModel?,
    val variants: List<ComicSummaryModel>?,
    val collections: List<ComicSummaryModel>?,
    val collectedIssues: List<ComicSummaryModel>?,
    val dates: List<ComicDate>?,
    val prices: List<ComicPrice>?,
    val thumbnail: ThumbnailModel?,
    val images: List<ThumbnailModel>?,
    val creators: CreatorsList?,
    val characters: CharactersList?
)