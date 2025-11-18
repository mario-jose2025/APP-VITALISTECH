package com.example.clinica_vitalistech

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CitasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_citas)



        // Inicializar el botón Cancelar
        val btnCancelar2: Button = findViewById(R.id.btnCancelar2)
        btnCancelar2.setOnClickListener {
            // Cerrar la actividad y volver a MainActivity
            finish()
        }

    }
}
