package com.oliverworks.myapp.data.pojo.moviesDetails

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class BelongsToCollection(

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("name")
    var name: String = "",

    @SerializedName("poster_path")
    var posterPath: String = "",

    @SerializedName("backdrop_path")
    var backdropPath: String = ""
) : Parcelable