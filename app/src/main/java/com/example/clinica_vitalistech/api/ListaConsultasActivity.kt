package com.example.clinica_vitalistech.api
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.clinica_vitalistech.api.com.example.clinica_vitalistech.api.ConsultasScreen

class ListaConsultasActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConsultasScreen()
        }
    }
}

