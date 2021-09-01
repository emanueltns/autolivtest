package com.example.autolivtest.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.autolivtest.R
import com.example.autolivtest.databinding.ActivityMainBinding
import com.example.autolivtest.services.model.Trip
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val tripsViewModel: TripsViewModel by viewModel()
    private lateinit var tripsAdapter : TripsAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        subscribeObservers()
        tripsAdapter = TripsAdapter(listOf()) {trip : Trip -> onItemClicked(trip) }
        binding.tripsList.adapter = tripsAdapter
        tripsViewModel.fetchTrips()
    }

    private fun subscribeObservers() {
        tripsViewModel.tripsList.observe(this) { items ->
            items?.let {
                tripsAdapter.updateData(it)
            }
        }
        tripsViewModel.errorResponse.observe(this) { error ->
            error?.let {
                Toast.makeText(this, "Error: $error", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun onItemClicked(trip : Trip) {
        Toast.makeText(this, "item clicked: ${trip.location}", Toast.LENGTH_LONG).show()
    }
}