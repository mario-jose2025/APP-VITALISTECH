package com.example.clinica_vitalistech

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Asegúrate de que este sea el nombre correcto de tu layout

        // Inicializar el botón "Iniciar"
        val buttonIniciar = findViewById<Button>(R.id.btniniciar) // Id del botón que recibe la acción
        buttonIniciar.setOnClickListener {
            // Navegar a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // 🔹 Cierra LoginActivity para que no vuelva al presionar atrás
        }

        // Inicializar el TextView para registrarse
        val tvRegistrate: TextView = findViewById(R.id.registernew)
        tvRegistrate.setOnClickListener {
            // Crear un Intent para ir a la actividad de registro
            val intent = Intent(this, RegisterAccountActivity::class.java)
            startActivity(intent)
        }
    }
}

