package me.lgcode.agepedia.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint
import me.lgcode.agepedia.ui.AgePediaTheme
import me.lgcode.agepedia.ui.civsList.CivList
import me.lgcode.agepedia.ui.civsList.CivsListViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: CivsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchCivs()
        setContent {
            AgePediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CivList(viewModel)
                }
            }
        }
    }
}