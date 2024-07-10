package com.example.escooters.data.model

data class Scooter(
    val id: String,
    val name: String,
    val city: String,
    val batteryLevel: Int,
    val isInUse: Boolean,
    val needsFix: Boolean,
    val totalRides: Int
)