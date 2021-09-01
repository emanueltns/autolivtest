package com.example.autolivtest.services.impl

import com.example.autolivtest.services.TripsProvider
import com.example.autolivtest.services.TripsService
import com.example.autolivtest.services.model.TripsResponse
import com.example.autolivtest.util.enqueue
import com.example.autolivtest.util.Result
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class TripsServiceImpl(private val provider : TripsProvider) : TripsService {

    override suspend fun getAllTrips(): Result<TripsResponse> =
        suspendCancellableCoroutine { continuation ->
            provider.getAllTrips().enqueue {
                continuation.resume(it)
            }
        }
}