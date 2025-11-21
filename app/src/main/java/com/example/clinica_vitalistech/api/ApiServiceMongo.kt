package com.example.clinica_vitalistech.api
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceMongo {

    @GET("api/medico/todos")
    fun getMedicos(): Call<List<DimMedico>>
}