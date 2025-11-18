package com.example.clinica_vitalistech

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    // Referencias a las vistas
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el BottomNavigationView
        val bottomNavigationView = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_settings -> {
                    Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_perfil -> {
                    Toast.makeText(this, "Abriendo Perfil de Usuario...", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, PerfilUsuarioActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


        // Inicializar vistas con sus IDs
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)

        // Configurar la Toolbar como ActionBar
        setSupportActionBar(toolbar)

        // Configurar el botón de hamburguesa (DrawerToggle)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Listener del menú lateral
        navigationView.setNavigationItemSelectedListener(this)

        // Cargar vista por defecto (opcional)
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_dashboard)
        }
    }

    // Método para cambiar fragmentos
    private fun loadFragment(fragment: Fragment, title: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, fragment)
            .commit()
        supportActionBar?.title = title
    }

    // Manejar los clics del menú lateral
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_paciente -> {
                Toast.makeText(this, "Abriendo: Registrar Paciente", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, PacientesActivity::class.java))
            }


            R.id.nav_citas -> {
                Toast.makeText(this, "Abriendo: Gestión de Citas", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, CitasActivity::class.java))
            }

            R.id.nav_dashboard -> {
                Toast.makeText(this, "Abriendo Dashboard...", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, DashboardActivity::class.java))
            }

            R.id.listado_paciente -> {
                Toast.makeText(this, "Listando Pacientes...", Toast.LENGTH_SHORT).show()
                loadFragment(PacienteFragment(), "Listado de Pacientes")
            }

            R.id.nav_info -> {
                Toast.makeText(this, "Abriendo Información...", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, InfoActivity::class.java))
            }

            R.id.nav_ajustes -> {
                Toast.makeText(this, "Abriendo Ajustes...", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_cerrar_sesion -> {
                Toast.makeText(this, "Cerrando Sesión...", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
            }

            R.id.nav_api_paciente -> {
                Toast.makeText(this, "Cargando datos desde la API...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, com.example.clinica_vitalistech.api.ListaPacientesActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_api_consulta -> {
                Toast.makeText(this, "Cargando datos desde la API...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, com.example.clinica_vitalistech.api.ListaConsultasActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_api_medicos -> {
                Toast.makeText(this, "Cargando datos desde la API...", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, com.example.clinica_vitalistech.api.ListaMedicosActivity::class.java)
                startActivity(intent)
            }

        }

        drawerLayout.closeDrawers()
        return true
    }
}
