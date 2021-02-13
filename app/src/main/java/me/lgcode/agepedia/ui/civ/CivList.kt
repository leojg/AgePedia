package me.lgcode.agepedia.ui.civ

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
import me.lgcode.agepedia.repository.domain.CivModel

@Composable
fun CivList(viewModel: CivsListViewModel) {

    val query = viewModel.queryLiveData.observeAsState("")
    val civs = viewModel.civs().observeAsState(listOf())

    Column {
        TopAppBar {
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
            items(civs.value) { civ ->
                CivCard(civ)
            }
        }
    }
}

@Composable
fun CivCard(civ: CivModel) {

    val modifier = Modifier.fillMaxWidth().padding(8.dp)

    Card(
            shape = RoundedCornerShape(8.dp),
            modifier = modifier
    ) {
        CivDetailComponent(civ)
    }
}