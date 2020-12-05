package com.oliverworks.myapp.Classes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actor (
        var name:String,
        var pathAvatar:Int
        ) : Parcelable