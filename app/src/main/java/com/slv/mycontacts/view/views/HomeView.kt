package com.slv.mycontacts.view.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.slv.mycontacts.view.components.MyTopBarNavigation

@Composable
fun HomeView(
    onOpenDrawer: () -> Unit,
    navigateAddContact: () -> Unit
) {

    var tf_contact by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            MyTopBarNavigation(
                title = "Inicio",
                isHomeScreen = true, // Muestra el icono de menú hamburguesa
                onNavigateClick = onOpenDrawer // Abre el menú
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 16.dp, end = 8.dp)
                    .size(60.dp),
                onClick = { navigateAddContact() },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = tf_contact,
                onValueChange = { tf_contact = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                label = { Text("Buscar contacto") },
                colors = OutlinedTextFieldDefaults.colors()
            )
        }
    }
}