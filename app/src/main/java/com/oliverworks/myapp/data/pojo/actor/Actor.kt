package com.oliverworks.myapp.data.pojo.actor

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Actor {

    @SerializedName("adult")
    @Expose
    var adult: Boolean? = null

    @SerializedName("also_known_as")
    @Expose
    var alsoKnownAs: List<String>? = null

    @SerializedName("biography")
    @Expose
    var biography: String? = null

    @SerializedName("birthday")
    @Expose
    var birthday: String? = null

    @SerializedName("deathday")
    @Expose
    var deathday: Any? = null

    @SerializedName("gender")
    @Expose
    var gender: Int? = null

    @SerializedName("homepage")
    @Expose
    var homepage: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("imdb_id")
    @Expose
    var imdbId: String? = null

    @SerializedName("known_for_department")
    @Expose
    var knownForDepartment: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("place_of_birth")
    @Expose
    var placeOfBirth: String? = null

    @SerializedName("popularity")
    @Expose
    var popularity: Double? = null

    @SerializedName("profile_path")
    @Expose
    var profilePath: String? = null
    fun getProfilePathW500() = "https://image.tmdb.org/t/p/w500${this.profilePath}"
    fun getProfilePathW300() = "https://image.tmdb.org/t/p/w300${this.profilePath}"
    fun getProfilePathW185() = "https://image.tmdb.org/t/p/w185${this.profilePath}"
}