package com.example.flightscry

data class Flight(
    val flightNumber: String,
    val airline: String,
    val departureAirport: String,
    val departureCity: String,
    val departureTime: String,
    val arrivalAirport: String,
    val arrivalCity: String,
    val arrivalTime: String,
    val duration: String,
    val price: String,
    val status: FlightStatus = FlightStatus.ON_TIME
)

enum class FlightStatus(val label: String) {
    ON_TIME("On Time"),
    DELAYED("Delayed"),
    BOARDING("Boarding"),
    DEPARTED("Departed")
}
