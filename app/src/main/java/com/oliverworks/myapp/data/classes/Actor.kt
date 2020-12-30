package com.oliverworks.myapp.data.classes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Actor(
    val id: Int,
    val name: String,
    val picture: String
): Parcelable