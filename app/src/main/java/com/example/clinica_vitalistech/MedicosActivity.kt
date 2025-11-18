package com.example.clinica_vitalistech

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.Button
import androidx.core.view.WindowInsetsCompat

class MedicosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicos)

        // Inicializar el botón Cancelar
        val btnCancelar1: Button = findViewById(R.id.btnCancelar1)
        btnCancelar1.setOnClickListener {
            // Cerrar la actividad y volver a MainActivity
            finish()
        }
    }
}

