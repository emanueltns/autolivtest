package com.example.autolivtest.api

import android.text.TextUtils
import okhttp3.OkHttpClient
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private const val API_BASE_URL = "https://autoliv.github.io/"

    private val httpClient = OkHttpClient.Builder()

    private val builder: Builder = Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private var retrofit = builder.build()


    fun <S> createService(serviceClass: Class<S>, authToken: String = ""): S {
        if (!TextUtils.isEmpty(authToken)) {
            val interceptor = AuthenticationInterceptor(authToken)

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor)

                builder.client(httpClient.build())
                retrofit = builder.build()
            }
        }
        return retrofit.create(serviceClass)
    }
}

