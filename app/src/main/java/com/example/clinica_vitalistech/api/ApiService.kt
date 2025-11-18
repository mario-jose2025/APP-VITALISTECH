package com.example.clinica_vitalistech.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/DimPacientes/DTO")
    fun getPacientes(): Call<List<DimPaciente>>

    @GET("api/DimConsultas/DTO")
    fun getConsultas(): Call<List<DimConsulta>>


    @GET("medico")
    fun getMedicos(): Call<List<DimMedico>>

}
