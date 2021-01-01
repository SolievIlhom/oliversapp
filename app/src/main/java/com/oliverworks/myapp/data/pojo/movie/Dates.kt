package com.oliverworks.myapp.data.pojo.movie

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Dates {

    @SerializedName("maximum")
    @Expose
    var maximum: String? = null

    @SerializedName("minimum")
    @Expose
    var minimum: String? = null
}