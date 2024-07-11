package com.example.escooters.data.model

import com.google.gson.annotations.SerializedName

data class ScootersResponse(
    @SerializedName("name") var name: String = "",
    @SerializedName("scooters") var scooters: ArrayList<Scooter> = arrayListOf(),
)
