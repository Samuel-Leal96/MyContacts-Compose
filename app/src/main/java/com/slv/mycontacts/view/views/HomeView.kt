package com.slv.mycontacts.view.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.slv.mycontacts.view.components.MyTopBarNavigation


@Composable
fun HomeView(
    onOpenDrawer: () -> Unit,
    navigateAddContact: () -> Unit
) {


    Scaffold(
        topBar = {
            MyTopBarNavigation(
                title = "Inicio",
                isHomeScreen = true, // Muestra el icono de menú hamburguesa
                onNavigateClick = onOpenDrawer // Abre el menú
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.Red)
                .fillMaxSize()
        )
    }
}

//@Composable
//fun HomeView(navigateAddContact: () -> Unit) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Cyan),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            "Home view", fontSize = 20.sp, modifier = Modifier
//                .padding(16.dp)
//        )
//
//        Button(onClick = {navigateAddContact()}) {
//            Text("Add contact")
//        }
//    }
//}