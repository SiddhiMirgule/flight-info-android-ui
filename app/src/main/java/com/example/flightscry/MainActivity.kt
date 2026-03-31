package com.example.flightscry

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flightscry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "FlightScry"

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val flights = getSampleFlights()

        val adapter = FlightAdapter(flights) { flight ->
            Toast.makeText(
                this,
                "${flight.flightNumber} — ${flight.departureAirport} to ${flight.arrivalAirport}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.recyclerFlights.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
            setHasFixedSize(true)
        }
    }

    private fun getSampleFlights(): List<Flight> = listOf(
        Flight(
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
        ),
        Flight(
            flightNumber = "AA 342",
            airline = "American Airlines",
            departureAirport = "JFK",
            departureCity = "New York",
            departureTime = "08:30 AM",
            arrivalAirport = "LHR",
            arrivalCity = "London",
            arrivalTime = "08:15 PM",
            duration = "7h 45m",
            price = "$620",
            status = FlightStatus.BOARDING
        ),
        Flight(
            flightNumber = "EK 204",
            airline = "Emirates",
            departureAirport = "DXB",
            departureCity = "Dubai",
            departureTime = "02:15 PM",
            arrivalAirport = "LAX",
            arrivalCity = "Los Angeles",
            arrivalTime = "06:45 PM",
            duration = "16h 30m",
            price = "$1,120",
            status = FlightStatus.ON_TIME
        ),
        Flight(
            flightNumber = "BA 117",
            airline = "British Airways",
            departureAirport = "LHR",
            departureCity = "London",
            departureTime = "11:00 AM",
            arrivalAirport = "SIN",
            arrivalCity = "Singapore",
            arrivalTime = "07:30 AM",
            duration = "13h 30m",
            price = "$875",
            status = FlightStatus.DELAYED
        ),
        Flight(
            flightNumber = "QF 002",
            airline = "Qantas",
            departureAirport = "SYD",
            departureCity = "Sydney",
            departureTime = "04:00 PM",
            arrivalAirport = "DFW",
            arrivalCity = "Dallas",
            arrivalTime = "06:25 PM",
            duration = "17h 25m",
            price = "$1,340",
            status = FlightStatus.ON_TIME
        ),
        Flight(
            flightNumber = "LH 400",
            airline = "Lufthansa",
            departureAirport = "FRA",
            departureCity = "Frankfurt",
            departureTime = "10:05 AM",
            arrivalAirport = "ORD",
            arrivalCity = "Chicago",
            arrivalTime = "12:55 PM",
            duration = "9h 50m",
            price = "$710",
            status = FlightStatus.DEPARTED
        )
    )
}
