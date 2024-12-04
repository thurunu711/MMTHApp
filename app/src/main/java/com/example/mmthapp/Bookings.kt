package com.example.mmthapp

data class Bookings(
    val UserID: String,
    val Date: String,
    val Time: String,
    val VehicleID: String,
    val BookSeats: List<String>,
    val Mode: String

)
