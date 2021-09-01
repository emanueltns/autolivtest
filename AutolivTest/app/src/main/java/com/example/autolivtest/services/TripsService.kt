package com.example.autolivtest.services

import com.example.autolivtest.services.model.TripsResponse
import com.example.autolivtest.util.Result

interface TripsService {
    suspend fun getAllTrips() : Result<TripsResponse>
}