package me.lgcode.agepedia.ui.tech

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import me.lgcode.agepedia.R
import me.lgcode.agepedia.repository.domain.Age
import me.lgcode.agepedia.repository.domain.Cost
import me.lgcode.agepedia.repository.domain.Expansion
import me.lgcode.agepedia.repository.domain.TechModel
import me.lgcode.agepedia.repository.local.TechEntity
import me.lgcode.agepedia.ui.common.CostComponent
import me.lgcode.agepedia.ui.common.SimpleLabeledTextComponent

@Composable
fun TechDetailComponent(tech: TechModel) {
    val modifier = Modifier.fillMaxWidth().padding(8.dp)

    Card(
            shape = RoundedCornerShape(8.dp),
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
            
            Spacer(modifier = Modifier.preferredSize(4.dp))
            
            CostComponent(cost = tech.cost)

            SimpleLabeledTextComponent(stringResource(R.string.build_time), tech.buildTime.toString())
            

        }
    }
}

@Preview
@Composable
fun TechCardPreview() {
    val techModel = TechEntity(
            id = 1,
            name = "Test",
            description = "Desc Desc Desc Desc Desc Desc Desc Desc Desc Desc Desc Desc",
            expansion = Expansion.FORGOTTEN,
            age = Age.IMPERIAL,
            developsIn = "url",
            cost = Cost(wood = 1234, food = 1423, gold = 4321, stone = 2134),
            buildTime = 123,
            appliesTo = listOf("test", "test", "test")
    )
    Box {
        TechDetailComponent(techModel)
    }
}