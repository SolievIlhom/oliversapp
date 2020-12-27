package com.oliverworks.myapp.data.classes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster: String,
    val backdrop: String,
    val ratings: Float,
    val adult: Boolean,
    val runtime: Int,
    val genres: List<Genre>,
    val actors: List<Actor>
) : Parcelable{
    val startRating: Float
        get() = ratings / 2
}