package com.slv.mycontacts.view.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slv.mycontacts.view.components.MyTopBarNavigation

@Composable
fun AddContactView(navigateBack: () -> Unit) {

    Scaffold(topBar =
        { MyTopBarNavigation(
            title = "Agregar contacto",
            isHomeScreen = false,
            onNavigateClick = navigateBack
        ) }
    ) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding))
    }

}