package com.slv.mycontacts.view.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarNavigation(
    title: String,
    isHomeScreen: Boolean,
    onNavigateClick: () -> Unit,
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (!isHomeScreen) {
                IconButton(onClick = onNavigateClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                    )
                }
            }
        },
    )
}