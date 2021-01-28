package com.oliverworks.myapp.data.pojo.actor

import com.google.gson.annotations.SerializedName

class Actor (

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("name")
    var name: String = "",

    @SerializedName("profile_path")
    var profilePath: String = "",
){
    fun getProfilePathW500() = "https://image.tmdb.org/t/p/w500${this.profilePath}"
    fun getProfilePathW300() = "https://image.tmdb.org/t/p/w300${this.profilePath}"
    fun getProfilePathW185() = "https://image.tmdb.org/t/p/w185${this.profilePath}"
}