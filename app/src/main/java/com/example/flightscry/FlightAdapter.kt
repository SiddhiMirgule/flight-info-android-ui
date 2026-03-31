package com.example.flightscry

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class FlightAdapter(
    private val flights: List<Flight>,
    private val onFlightClick: (Flight) -> Unit
) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    inner class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardFlight)
        val tvFlightNumber: TextView = itemView.findViewById(R.id.tvFlightNumber)
        val tvAirline: TextView = itemView.findViewById(R.id.tvAirline)
        val tvDepartureCode: TextView = itemView.findViewById(R.id.tvDepartureCode)
        val tvDepartureCity: TextView = itemView.findViewById(R.id.tvDepartureCity)
        val tvDepartureTime: TextView = itemView.findViewById(R.id.tvDepartureTime)
        val tvArrivalCode: TextView = itemView.findViewById(R.id.tvArrivalCode)
        val tvArrivalCity: TextView = itemView.findViewById(R.id.tvArrivalCity)
        val tvArrivalTime: TextView = itemView.findViewById(R.id.tvArrivalTime)
        val tvDuration: TextView = itemView.findViewById(R.id.tvDuration)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_flight, parent, false)
        return FlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val flight = flights[position]

        holder.tvFlightNumber.text = flight.flightNumber
        holder.tvAirline.text = flight.airline
        holder.tvDepartureCode.text = flight.departureAirport
        holder.tvDepartureCity.text = flight.departureCity
        holder.tvDepartureTime.text = flight.departureTime
        holder.tvArrivalCode.text = flight.arrivalAirport
        holder.tvArrivalCity.text = flight.arrivalCity
        holder.tvArrivalTime.text = flight.arrivalTime
        holder.tvDuration.text = flight.duration
        holder.tvPrice.text = flight.price
        holder.tvStatus.text = flight.status.label

        // Status color
        val statusColor = when (flight.status) {
            FlightStatus.ON_TIME -> ContextCompat.getColor(holder.itemView.context, R.color.status_on_time)
            FlightStatus.DELAYED -> ContextCompat.getColor(holder.itemView.context, R.color.status_delayed)
            FlightStatus.BOARDING -> ContextCompat.getColor(holder.itemView.context, R.color.status_boarding)
            FlightStatus.DEPARTED -> ContextCompat.getColor(holder.itemView.context, R.color.status_departed)
        }
        holder.tvStatus.setTextColor(statusColor)

        holder.cardView.setOnClickListener { onFlightClick(flight) }
    }

    override fun getItemCount(): Int = flights.size
}
