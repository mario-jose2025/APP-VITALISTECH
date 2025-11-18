package com.example.clinica_vitalistech

import retrofit2.http.GET

interface ApiService {
    @GET("paciente")
    suspend fun getPaciente(): List<Paciente>
}
