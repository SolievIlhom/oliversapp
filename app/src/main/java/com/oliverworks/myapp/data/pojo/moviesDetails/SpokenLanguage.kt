package com.oliverworks.myapp.data.pojo.moviesDetails

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SpokenLanguage(

    @SerializedName("english_name")
    @Expose
    var englishName: String? = null,

    @SerializedName("iso_639_1")
    @Expose
    var iso6391: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
) : Parcelable