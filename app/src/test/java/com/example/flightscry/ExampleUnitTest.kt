package com.example.flightscry

import org.junit.Test
import org.junit.Assert.*

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun flightDataModel_isCorrect() {
        val flight = Flight(
            flightNumber = "DL 177",
            airline = "Delta Airlines",
            departureAirport = "SEA",
            departureCity = "Seattle",
            departureTime = "10:45 AM",
            arrivalAirport = "SPU",
            arrivalCity = "Split",
            arrivalTime = "10:50 PM",
            duration = "12h 05m",
            price = "$489",
            status = FlightStatus.ON_TIME
        )
        assertEquals("DL 177", flight.flightNumber)
        assertEquals("SEA", flight.departureAirport)
        assertEquals("SPU", flight.arrivalAirport)
        assertEquals(FlightStatus.ON_TIME, flight.status)
    }
}
