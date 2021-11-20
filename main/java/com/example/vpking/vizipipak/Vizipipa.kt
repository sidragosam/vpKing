package com.example.vpking.vizipipak

import android.os.Parcelable
import androidx.room.Entity
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Vizipipa (
    @field:Json(name = "nev")
    val nev: String,
) : Parcelable {}
