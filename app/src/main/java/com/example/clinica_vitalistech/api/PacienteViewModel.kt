package com.example.clinica_vitalistech.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class PacienteViewModel : ViewModel() {

    var pacientes by mutableStateOf<List<DimPaciente>>(emptyList())
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getPacientes() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPacientes().awaitResponse()
                if (response.isSuccessful) {
                    pacientes = response.body() ?: emptyList()
                } else {
                    errorMessage = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }
}
