package com.slv.mycontacts.view.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.slv.mycontacts.view.views.AddContactView
import com.slv.mycontacts.view.views.HomeView
import kotlinx.coroutines.launch

//@Composable
//fun NavigationWrapper(modifier: Modifier) {
//    val navController = rememberNavController()
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val scope = rememberCoroutineScope() // Necesario para abrir/cerrar el drawer de forma asíncrona
//
//    ModalNavigationDrawer(
//        modifier = modifier,
//        drawerState = drawerState,
//        drawerContent = {
//            ModalDrawerSheet {
//                // Elemento del menú: Inicio
//                NavigationDrawerItem(
//                    label = { Text("Inicio") },
//                    icon = { iconHome() },
//                    selected = false, // Puedes manejar aquí cuál está seleccionado
//                    onClick = {
//                        scope.launch { drawerState.close() }
//                        navController.navigate(HomeScreen) {
//                            // Limpia el backstack para no acumular pantallas de inicio
//                            popUpTo(navController.graph.startDestinationId) { saveState = true }
//                            launchSingleTop = true
//                            restoreState = true
//                        }
//                    }
//                )
//
//                HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
//
//                // Elemento del menú: Agregar Contacto
//                NavigationDrawerItem(
//                    label = { Text("Agregar Contacto") },
//                    icon = {iconAddContact()},
//                    selected = false,
//                    onClick = {
//                        scope.launch { drawerState.close() }
//                        navController.navigate(AddContactScreen)
//                    }
//                )
//            }
//        }
//    ) {
//        // Contenido de la app que interactúa con el Drawer
//        NavHost(navController = navController, startDestination = HomeScreen) {
//
//            composable<HomeScreen> {
//                // Pantalla de Inicio (Nivel superior: muestra hamburguesa para abrir el drawer)
//                HomeView(
//                    onOpenDrawer = {
//                        scope.launch { drawerState.open() }
//                    },
//                    navigateAddContact = {
//                        navController.navigate(AddContactScreen)
//                    }
//                )
//            }
//
//            composable<AddContactScreen> {
//                // Pantalla Secundaria (Muestra flecha hacia atrás para regresar en la pila)
//                AddContactView(
//                    navigateBack = {
//                        navController.popBackStack()
//                    }
//                )
//            }
//        }
//    }
//}

@Composable
fun iconHome() {
    Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
}

@Composable
fun iconAddContact(modifier: Modifier = Modifier) {
    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Contact")
}

@Composable
fun NavigationWrapper(modifier: Modifier){
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen){
        composable<HomeScreen>{
            HomeView(navigateAddContact = {navController.navigate(AddContactScreen)})
        }

        composable<AddContactScreen> {
            AddContactView( navigateBack = {navController.popBackStack()}  )
        }
    }
}