package me.lgcode.agepedia.ui.civ

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import me.lgcode.agepedia.R
import me.lgcode.agepedia.repository.domain.CivModel
import me.lgcode.agepedia.repository.domain.Expansion
import me.lgcode.agepedia.repository.local.CivEntity
import me.lgcode.agepedia.ui.common.SimpleLabeledTextComponent

@Composable
fun CivDetailComponent(civ: CivModel) {
    Column(modifier = Modifier.padding(5.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                    text = civ.name,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.align(Alignment.CenterStart)
            )

            val icon = when(civ.expansion) {
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
                text = civ.type,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(PaddingValues(top = 5.dp, bottom = 5.dp))
        )

        Column(modifier = Modifier.background(MaterialTheme.colors.onSurface, RoundedCornerShape(8.dp))) {
            CivCardInnerRow(stringResource(R.string.civ_bonus), civ.civBonus)
            CivCardInnerRow(stringResource(R.string.civ_units), civ.uniqueUnits)
            CivCardInnerRow(stringResource(R.string.civ_techs), civ.uniqueTechs)
        }

        SimpleLabeledTextComponent(stringResource(R.string.team_bonus), civ.teamBonus)

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
    val civ = CivEntity(
            2,
            "sepepe",
            Expansion.AFRICAN,
            "epyt",
            listOf("civTechs1", "civTechs2"),
            listOf("uniqueTechs1", "uniqueTechs2"),
            "teamBonus",
            listOf("civBonus1", "civBonus2"),
    )
    Box {
        CivDetailComponent(civ)
    }
}