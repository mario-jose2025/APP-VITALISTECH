package com.example.clinica_vitalistech.api

data class DimMedico(
    val id: String,
    val codigo: String,
    val nombres: String,
    val apellidos: String,
    val fechanacimiento: String,
    val direccion: String,
    val telefono: String,
    val especialidad: String
)
