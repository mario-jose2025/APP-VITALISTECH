package com.example.clinica_vitalistech.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class MedicoViewModel : ViewModel() {

    private val api = RetrofitMedico.api

    private val _medicos = mutableStateOf<List<DimMedico>>(emptyList())
    val medicos: State<List<DimMedico>> get() = _medicos

    fun cargarMedicos() {
        viewModelScope.launch {
            try {
                val respuesta = api.getMedicos().execute()
                if (respuesta.isSuccessful) {
                    _medicos.value = respuesta.body() ?: emptyList()
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}
