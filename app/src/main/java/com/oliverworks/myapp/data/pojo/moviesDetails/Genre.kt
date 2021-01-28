package com.oliverworks.myapp.data.pojo.moviesDetails

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Genre(
    @SerializedName("id")
    var idGenre: Int = 0,

    @SerializedName("name")
    var nameGenre: String = ""
) : Parcelable