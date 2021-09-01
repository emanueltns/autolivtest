package com.example.autolivtest.services.model

import com.google.gson.annotations.SerializedName

data class TripsResponse(val trips : List<Trip>)

data class Trip(@SerializedName("id") val id : String,
                @SerializedName("start")val startDate : String,
                @SerializedName("end") val endDate : String,
                @SerializedName("location") val location : Location,
                @SerializedName("image") val imageUrl : String,
)

data class Location(@SerializedName("start") val startLocation : LocationDate,
                    @SerializedName("end") val endLocation : LocationDate)

data class LocationDate(@SerializedName("city") val city: String,
                         @SerializedName("county") val county: String,
                         @SerializedName("country") val country : String)