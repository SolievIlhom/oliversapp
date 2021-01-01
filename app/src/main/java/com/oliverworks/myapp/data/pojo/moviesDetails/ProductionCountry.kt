package com.oliverworks.myapp.data.pojo.moviesDetails

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductionCountry(
    @SerializedName("iso_3166_1")
    @Expose
    var iso31661: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
) : Parcelable