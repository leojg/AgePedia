package me.lgcode.agepedia.ui.techList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.lgcode.agepedia.R
import me.lgcode.agepedia.repository.domain.Expansion
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
        Column(modifier = Modifier.padding(5.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = tech.name,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.align(Alignment.CenterStart)
                )

                val icon = when(tech.expansion) {
                    Expansion.AOK -> loadImageResource(id = R.drawable.aok)
                    Expansion.AOC -> loadImageResource(id = R.drawable.aoc)
                    Expansion.FORGOTTEN -> loadImageResource(id = R.drawable.forgotten)
                    Expansion.RAJAS -> loadImageResource(id = R.drawable.rajas)
                    Expansion.AFRICAN -> loadImageResource(id = R.drawable.african)
                }

                icon.resource.resource?.let {
                    Image(
                        bitmap = it,
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.CenterEnd).padding(PaddingValues(end = 5.dp))
                    )
                }
            }

            Text(
                text = tech.description,
                modifier = Modifier.padding(PaddingValues(end = 15.dp)),
                style = MaterialTheme.typography.body1
            )
            Text(
                text = stringResource(id = R.string.age, formatArgs = arrayOf(tech.age.value)),
                modifier = Modifier.padding(PaddingValues(end = 15.dp)),
                style = MaterialTheme.typography.body1
            )

        }
    }
}

@Composable
fun TechCardInnerRow(label: String, list: List<String>) {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(label, style = MaterialTheme.typography.subtitle2, modifier = Modifier.padding(
            PaddingValues(bottom = 4.dp)
        ))
        LazyRow {
            items(list) { item ->
                Text(
                    text = item,
                    modifier = Modifier.padding(PaddingValues(end = 6.dp)),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}