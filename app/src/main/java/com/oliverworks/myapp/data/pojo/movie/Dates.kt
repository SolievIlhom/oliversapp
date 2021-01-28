package com.oliverworks.myapp.data.pojo.movie

import com.google.gson.annotations.SerializedName

class Dates (
    @SerializedName("maximum")
    var maximum: String = "",

    @SerializedName("minimum")
    var minimum: String = ""
)