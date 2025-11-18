package com.example.clinica_vitalistech

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class PacienteViewModel : ViewModel() {
    private val api = ApiPaciente.create()

    private val _loading = MutableLiveData(false)

    val loading: LiveData<Boolean> = _loading

    private val _paciente = MutableLiveData<List<Paciente>>(emptyList())
    val paciente: LiveData<List<Paciente>> = _paciente

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    fun load() {
        // Si ya está cargando, no hacemos nada
        if (_loading.value == true) return

        // Indicamos que estamos cargando datos
        _loading.value = true
        _error.value = null

        // Usamos viewModelScope para realizar la llamada a la API
        viewModelScope.launch {
            try {
                // Llamamos a la API para obtener la lista de pacientes
                _paciente.value = api.getPaciente() // Cambia esto por el método correcto en tu API
            } catch (e: Exception) {
                // Capturamos cualquier error y lo asignamos a _error
                _error.value = e.message ?: "Error de red"
            } finally {
                // Indicamos que hemos terminado de cargar
                _loading.value = false
            }
        }
    }

}