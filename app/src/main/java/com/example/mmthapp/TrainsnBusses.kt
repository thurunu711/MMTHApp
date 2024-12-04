package com.example.mmthapp

data class TrainsnBusses(
    val trainID: String,
    val BusID: String,
    val Route: String,
    val Desitantion: String,
    val Departure: String,
    val Seats: List<String>,
    val Mode: String

)
