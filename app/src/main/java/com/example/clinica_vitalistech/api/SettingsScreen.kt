package com.example.clinica_vitalistech.api
import android.content.Intent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clinica_vitalistech.PerfilUsuarioActivity
import com.example.clinica_vitalistech.PerfilUsuarioScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onLogout: () -> Unit = {},

) {
    val context = LocalContext.current
    var isDarkTheme by remember { mutableStateOf(false) }
    var notificationsEnabled by remember { mutableStateOf(true) }
    var expandedLanguage by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("Español") }

    val languages = listOf("Español", "Inglés", "Francés")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ajustes") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                SettingsSection(title = "Cuenta")
            }

            item {
                SettingsItem(
                    icon = Icons.Default.Person,
                    title = "Perfil",
                    subtitle = "Gestiona tu información personal",
                    onClick = { context.startActivity(
                        Intent(context, PerfilUsuarioActivity::class.java)
                    )}
                )
            }

            item {
                SettingsSection(title = "Apariencia")
            }

            item {
                SwitchSetting(
                    icon = Icons.Default.DarkMode,
                    title = "Tema oscuro",
                    checked = isDarkTheme,
                    onCheckedChange = { isDarkTheme = it }
                )
            }

            item {
                SettingsSection(title = "Notificaciones")
            }

            item {
                SwitchSetting(
                    icon = Icons.Default.Notifications,
                    title = "Activar notificaciones",
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it }
                )
            }

            item {
                SettingsSection(title = "Idioma")
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expandedLanguage = !expandedLanguage }
                        .padding(16.dp)
                        .animateContentSize()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Language, contentDescription = null)
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = "Idioma",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(selectedLanguage)
                    }

                    if (expandedLanguage) {
                        Spacer(modifier = Modifier.height(12.dp))
                        languages.forEach { lang ->
                            Text(
                                text = lang,
                                modifier = Modifier
                                    .padding(start = 40.dp, bottom = 8.dp)
                                    .clickable {
                                        selectedLanguage = lang
                                        expandedLanguage = false
                                    }
                            )
                        }
                    }
                }
            }

            item {
                SettingsSection(title = "Privacidad")
            }

            item {
                SettingsItem(
                    icon = Icons.Default.Lock,
                    title = "Cambiar contraseña",
                    onClick = {}
                )
            }

            item {
                SettingsSection(title = "Sistema")
            }

            item {
                SettingsItem(
                    icon = Icons.Default.Sync,
                    title = "Sincronizar datos",
                    onClick = {}
                )
            }

            item {
                SettingsItem(
                    icon = Icons.Default.Info,
                    title = "Sobre la app",
                    subtitle = "Versión 1.0.0",
                    onClick = {}
                )
            }

            item {
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = onLogout,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error)
                ) {
                    Icon(Icons.Default.ExitToApp, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Cerrar sesión")
                }
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun SettingsSection(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 8.dp),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SettingsItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String? = null,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = title)
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(title, fontWeight = FontWeight.Bold)
                subtitle?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
fun SwitchSetting(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = title)
        Spacer(modifier = Modifier.width(16.dp))
        Text(title, modifier = Modifier.weight(1f))
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen()
}

