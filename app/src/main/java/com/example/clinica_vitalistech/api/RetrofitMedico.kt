package com.example.clinica_vitalistech.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitMedico {

    private const val BASE_URL_MONGO =
        "https://api-mongodemo20251120084538-d9byfye3e7g2a7gm.canadacentral-01.azurewebsites.net/"

    val api: ApiServiceMongo by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_MONGO)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServiceMongo::class.java)
    }
}

