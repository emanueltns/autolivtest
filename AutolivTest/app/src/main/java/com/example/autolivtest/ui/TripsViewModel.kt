package com.example.autolivtest.ui

import androidx.lifecycle.*
import com.example.autolivtest.services.TripsService
import com.example.autolivtest.services.model.Trip
import kotlinx.coroutines.launch
import com.example.autolivtest.util.Result

class TripsViewModel(val tripService : TripsService) :  ViewModel() {

    private val _tripsList = MutableLiveData<List<Trip>>()
    val tripsList: LiveData<List<Trip>> = _tripsList

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    fun fetchTrips() {
        viewModelScope.launch {
            val result = tripService.getAllTrips()
            if(result is Result.Success) {
                val response = result.response
                if(result.response.isSuccessful) {
                    _tripsList.postValue(response.body()?.trips)
                } else {
                    _errorResponse.postValue(response.message())
                }
            } else if(result is Result.Failure){
                _errorResponse.postValue(result.error.message)
            }
        }
    }
}