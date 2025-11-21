package com.example.clinica_vitalistech.api

import com.google.gson.annotations.SerializedName

data class DimMedico(
    @SerializedName("Codigo") val codigo: String?,
    @SerializedName("Nombres") val nombres: String?,
    @SerializedName("Apellidos") val apellidos: String?,
    @SerializedName("FechaNacimiento") val fechaNacimiento: String?,
    @SerializedName("Direccion") val direccion: String?,
    @SerializedName("Telefono") val telefono: String?,
    @SerializedName("EspecialidadId") val especialidadId: Int?
)