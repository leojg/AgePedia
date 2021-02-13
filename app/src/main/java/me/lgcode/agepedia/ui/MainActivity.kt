package me.lgcode.agepedia.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint
import me.lgcode.agepedia.ui.civ.CivsListViewModel
import me.lgcode.agepedia.ui.main.MainScreen
import me.lgcode.agepedia.ui.tech.TechsListViewModel
import me.lgcode.agepedia.ui.theme.AgePediaTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //TODO: Compose still has no good way of managing multiple viewmodels with hilt. Move to each composite when a solution is found
    val civsViewModel: CivsListViewModel by viewModels()
    val techsViewModel: TechsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgePediaTheme {
                // A surface container using the 'background' color from the theme
                MainScreen(civsViewModel, techsViewModel)
            }
        }
    }
}