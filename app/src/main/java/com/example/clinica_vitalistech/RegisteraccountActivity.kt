package com.example.clinica_vitalistech

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Habilitar el modo de borde a borde
        setContentView(R.layout.activity_registeraccount) // aca asignamos el nombre del Layout

        // Inicializar el botón "Iniciar sesión"
        val buttonIniciar = findViewById<Button>(R.id.loginaccount) // Id del botón que recibe la acción
        buttonIniciar.setOnClickListener {
            // Navegar a LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }

        // Inicializar el TextView para mostrar el enlace al login
        val txRegistrate: TextView = findViewById(R.id.textregistrar)
        txRegistrate.setOnClickListener {
            // Crear un Intent para ir a la actividad de login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
