package me.lgcode.agepedia.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import me.lgcode.agepedia.R
import me.lgcode.agepedia.ui.BaseViewModel
import me.lgcode.agepedia.ui.Screen
import me.lgcode.agepedia.ui.civ.CivCard
import me.lgcode.agepedia.ui.civ.CivDetailComponent
import me.lgcode.agepedia.ui.civ.CivList
import me.lgcode.agepedia.ui.civ.CivsListViewModel
import me.lgcode.agepedia.ui.tech.TechCard
import me.lgcode.agepedia.ui.tech.TechList
import me.lgcode.agepedia.ui.tech.TechsListViewModel

@Composable
fun MainScreen(
    civsListViewModel: CivsListViewModel,
    techsListViewModel: TechsListViewModel
) {
    civsListViewModel.fetchResults()
    techsListViewModel.fetchResults()

    val navControler = rememberNavController()

    val bottomNavigationItems = listOf(
        Screen.CivsList,
        Screen.TechsList,
    )
    
    Scaffold(
        bottomBar = {
            AgeBottomNavigation(navControler, bottomNavigationItems)
        }
    ) {
        NavHost(navController = navControler, Screen.CivsList.route) {
            composable(Screen.CivsList.route) {
                ItemList(civsListViewModel, ::CivCard)
            }
            composable(Screen.TechsList.route) {
                ItemList(techsListViewModel, ::TechCard)
            }
        }

    }
}

@Composable
fun <T: Any> ItemList(viewModel: BaseViewModel<T>, composable: (T) -> Unit) {

    val query = viewModel.queryLiveData.observeAsState("")
    val results = viewModel.results().observeAsState(listOf<T>())

    Column {
        TopAppBar(contentColor = Color.Black) {
            TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = query.value!!,
                    onValueChange = { newQuery ->
                        viewModel.updateQuery(newQuery)
                    },
                    label = {
                        Text(stringResource(id = R.string.search))
                    }
            )
        }

        LazyColumn {
            items(results.value) { result ->
                composable(result)
            }
        }
    }

}

@Composable
private fun AgeBottomNavigation(navController: NavHostController, items: List<Screen>) {
    BottomNavigation(backgroundColor = MaterialTheme.colors.primarySurface) {
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