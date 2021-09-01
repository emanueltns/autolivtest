package com.example.autolivtest.di

import com.example.autolivtest.api.ServiceGenerator
import com.example.autolivtest.services.TripsProvider
import com.example.autolivtest.services.TripsService
import com.example.autolivtest.services.impl.TripsServiceImpl
import com.example.autolivtest.ui.TripsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { ServiceGenerator.createService(TripsProvider::class.java, "") }
}

val serviceModule = module {
    single<TripsService>{ TripsServiceImpl(get())}
}

val viewModelsModule = module {
    viewModel { TripsViewModel(tripService = get()) }
}

