package com.oliverworks.myapp.Classes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Actor(
        val name: String,
        val pathAvatar: Int
) : Parcelable