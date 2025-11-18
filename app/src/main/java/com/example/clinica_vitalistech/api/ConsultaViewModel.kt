package com.example.clinica_vitalistech.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class ConsultaViewModel : ViewModel() {

    var consultas by mutableStateOf<List<DimConsulta>>(emptyList())
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getConsultas() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getConsultas().awaitResponse()
                if (response.isSuccessful) {
                    consultas = response.body() ?: emptyList()
                } else {
                    errorMessage = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }
}
