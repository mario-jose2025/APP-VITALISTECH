package com.example.clinica_vitalistech.api

data class DimPaciente(
    val idPaciente: Int,
    val codigoPaciente: String,
    val nombres: String,
    val apellidos: String,
    val genero: String,
    val direccion: String,
    val telefono: String
)
