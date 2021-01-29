package me.lgcode.agepedia.ui.civsList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import me.lgcode.agepedia.R
import me.lgcode.agepedia.repository.domain.CivModel
import me.lgcode.agepedia.repository.local.CivEntity

@Composable
fun CivList(viewModel: CivsListViewModel) {

    val civs = viewModel.civs().observeAsState(listOf())

    LazyColumn() {
        items(civs.value) { civ ->
            CivCard(civ)
        }
    }

}

@Composable
fun CivCard(civ: CivModel) {

    val modifier = Modifier.fillMaxWidth().padding(8.dp)

    Card(
            shape = RoundedCornerShape(8.dp),
            contentColor = Color.Black,
            modifier = modifier
    ) {
        Column(modifier = Modifier.padding(5.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                        text = civ.name,
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.align(Alignment.CenterStart)
                )
                Text(
                        text = civ.expansion,
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier.align(Alignment.CenterEnd).padding(PaddingValues(end = 5.dp))
                )
            }
            Text(
                    text = civ.type,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(PaddingValues(top = 5.dp, bottom = 5.dp))
            )

            Column(modifier = Modifier.background(MaterialTheme.colors.onSurface, RoundedCornerShape(8.dp))) {
                CivCardInnerRow(stringResource(R.string.civ_bonus), civ.civBonus)
                CivCardInnerRow(stringResource(R.string.civ_units), civ.uniqueUnits)
                CivCardInnerRow(stringResource(R.string.civ_techs), civ.uniqueTechs)
            }

            Text(
                    text = stringResource(R.string.team_bonus),
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(PaddingValues(top = 5.dp))
            )
            Text(
                    text = civ.teamBonus,
                    modifier = Modifier.padding(PaddingValues(end = 15.dp)),
                    style = MaterialTheme.typography.body1
            )

        }
    }
}

@Composable
fun CivCardInnerRow(label: String, list: List<String>) {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(label, style = MaterialTheme.typography.subtitle2, modifier = Modifier.padding(
            PaddingValues(bottom = 4.dp)))
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

@Preview
@Composable
fun CivListPreview() {
    val civs = listOf<CivModel>(
            CivEntity(
                    1,
                    "pepes",
                    "aok",
                    "type",
                    listOf("civTechs1", "civTechs2"),
                    listOf("uniqueTechs1", "uniqueTechs2", "uniqueTechs3", "uniqueTechs4", "uniqueTechs5", "uniqueTechs6"),
                    "teamBonus",
                    listOf("civBonus1", "civBonus2"),
            ),
            CivEntity(
                    2,
                    "sepepe",
                    "aok",
                    "epyt",
                    listOf("civTechs1", "civTechs2"),
                    listOf("uniqueTechs1", "uniqueTechs2"),
                    "teamBonus",
                    listOf("civBonus1", "civBonus2"),
            )
    )
    LazyColumn {
        items(civs) { civ ->
            CivCard(civ)
        }
    }
}