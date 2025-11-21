package com.example.clinica_vitalistech

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext

data class PerfilOpcion(
    val titulo: String,
    val onClick: () -> Unit
)

class PerfilUsuarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PerfilUsuarioScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilUsuarioScreen() {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Perfil") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF2196F3))
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF2F2F2)),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {

                // Imagen de perfil
                Image(
                    painter = painterResource(id = R.drawable.profile_pic),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(3.dp, Color.Gray, CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Nombre y correo
                Text("Mario Fargas", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text("mariofargas40@gmail.com", color = Color.Gray, fontSize = 16.sp)

                Spacer(modifier = Modifier.height(24.dp))

                Divider()

                Spacer(modifier = Modifier.height(16.dp))

                // Lista de opciones con acciones
                val opciones = listOf(
                    PerfilOpcion("Editar perfil") {
                        context.startActivity(Intent(context, EditarPerfilActivity::class.java))
                    },
                    PerfilOpcion("Historial de citas") {
                        Toast.makeText(context, "Historial de citas en construcción", Toast.LENGTH_SHORT).show()
                    },
                    PerfilOpcion("Configuración") {
                        // Abrir la pantalla de Ajustes
                        context.startActivity(Intent(context, SettingsActivity::class.java))
                    },
                    PerfilOpcion("Cerrar sesión") {
                        context.startActivity(Intent(context, LoginActivity::class.java))
                    }
                )

                LazyColumn {
                    items(opciones) { opcion ->
                        PerfilOpcionItem(opcion)
                    }
                }
            }
        }
    }
}

@Composable
fun PerfilOpcionItem(opcion: PerfilOpcion) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { opcion.onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(opcion.titulo, fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PerfilUsuarioPreview() {
    PerfilUsuarioScreen()
}
