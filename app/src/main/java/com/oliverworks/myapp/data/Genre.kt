package com.android.academy.fundamentals.homework.features.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre(
    val id: Int,
    val name: String
) : Parcelable{
    companion object {
        fun toStringName(list: List<Genre>): String {
            var str: String = ""
            list.forEach {
                str += it.name + ","
            }
            str.drop(str.length - 1)
            var str1 : String = ""
            val min1 : Int = minOf(20,str.length - 1)
            (0..min1).forEach { i ->
                str1+=str[i]
            }
            return str1.padEnd(3,'.')
        }
    }
}