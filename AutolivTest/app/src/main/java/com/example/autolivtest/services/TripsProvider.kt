package com.example.autolivtest.services

import com.example.autolivtest.services.model.TripsResponse
import retrofit2.Call
import retrofit2.http.GET

interface TripsProvider {
    @GET("interview-data.json")
    fun getAllTrips() : Call<TripsResponse>
}