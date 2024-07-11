package com.example.escooters.data.model

import com.google.gson.annotations.SerializedName

data class Scooter(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("battery") var battery: Float,
    @SerializedName("in_use") var inUse: Boolean,
    @SerializedName("need_fix") var needFix: Boolean,
    @SerializedName("total_rides") var totalRides: Int,
)
