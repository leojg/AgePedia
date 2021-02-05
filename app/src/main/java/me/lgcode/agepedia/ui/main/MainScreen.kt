package me.lgcode.agepedia.ui.main

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import me.lgcode.agepedia.ui.Screen
import me.lgcode.agepedia.ui.civ.CivList
import me.lgcode.agepedia.ui.civ.CivsListViewModel
import me.lgcode.agepedia.ui.tech.TechList
import me.lgcode.agepedia.ui.tech.TechsListViewModel

@Composable
fun MainScreen(
    civsListViewModel: CivsListViewModel,
    techsListViewModel: TechsListViewModel
) {
    civsListViewModel.fetchCivs()
    techsListViewModel.fetchTechs()

    val navControler = rememberNavController()

    val bottomNavigationItems = listOf(
        Screen.CivsList,
        Screen.TechsList,
    )
    
    Scaffold(
        bottomBar = { AgeBottomNavigation(navControler, bottomNavigationItems) }
    ) {
        NavHost(navController = navControler, Screen.CivsList.route) {
            composable(Screen.CivsList.route) {
                CivList(viewModel = civsListViewModel)
            }
            composable(Screen.TechsList.route) {
                TechList(viewModel = techsListViewModel)
            }
        }

    }
}

@Composable
private fun AgeBottomNavigation(navController: NavHostController, items: List<Screen>) {
    BottomNavigation() {
        val currentRoute = Screen.CivsList.route
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageResource(screen.icon), "") },
                label = { Text(stringResource(id = screen.label)) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route)
                }
            )
        }
    }
}