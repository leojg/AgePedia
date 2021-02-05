package me.lgcode.agepedia.ui.tech

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.lgcode.agepedia.R
import me.lgcode.agepedia.repository.domain.TechModel

@Composable
fun TechList(viewModel: TechsListViewModel) {

    val query = viewModel.queryLiveData.observeAsState("")
    val civs = viewModel.techs().observeAsState(listOf())

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
            items(civs.value) { tech ->
                TechCard(tech)
            }
        }
    }
}

@Composable
fun TechCard(tech: TechModel) {

    val modifier = Modifier.fillMaxWidth().padding(8.dp)

    Card(
        shape = RoundedCornerShape(8.dp),
        contentColor = Color.Black,
        modifier = modifier
    ) {
        TechDetailComponent(tech = tech)
    }
}