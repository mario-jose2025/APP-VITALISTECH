package com.example.clinica_vitalistech.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    // url de la api que publiqué en azure
    private const val BASE_URL = "https://vitalisapi-ezepdyguaugnd6bj.canadacentral-01.azurewebsites.net/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
