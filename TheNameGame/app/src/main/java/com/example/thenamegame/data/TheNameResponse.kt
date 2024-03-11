package com.example.thenamegame.data

import com.google.gson.annotations.SerializedName

data class TheNameResponse(
    @SerializedName("firstName") val firstName: String,
    @SerializedName("headshot") val headShot: HeadShot,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("id") val id: String

)

data class HeadShot(
    @SerializedName("url") val url: String?
)
