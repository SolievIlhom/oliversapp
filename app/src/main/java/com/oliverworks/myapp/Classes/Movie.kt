package com.oliverworks.myapp.Classes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
        var name:String = "",
        var rating:Float = 0.toFloat(),
        var reviews:Int = 0,
        var like:Boolean = false,
        var limitAge:Int = 0,
        var durationMin:Int = 0,
        var tag :String = "",
        var posterPath: Int = 0,
        var shortline : String = ""
): Parcelable