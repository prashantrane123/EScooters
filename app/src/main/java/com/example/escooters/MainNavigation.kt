package com.example.escooters

import kotlinx.serialization.Serializable

@Serializable
object ScooterScreenRoute

@Serializable
data class ScooterDetailScreenRoute(
    val id: Int,
    val name: String,
    val battery: Float,
    val inUse: Boolean,
    val needFix: Boolean,
    val totalRides: Int,
)