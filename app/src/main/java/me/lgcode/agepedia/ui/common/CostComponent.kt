package me.lgcode.agepedia.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.loadImageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import me.lgcode.agepedia.R
import me.lgcode.agepedia.repository.domain.Cost

@Composable
fun CostComponent(cost: Cost) {
    val modifier = Modifier
            .width(20.dp)
            .height(20.dp)
            .padding(
                    PaddingValues(
                            start = 5.dp,
                            end = 5.dp
                    )
            )
    Row {
        if (cost.food > 0) {
            loadImageResource(R.drawable.food).resource.resource?.let {
                Image(
                        bitmap = it,
                        contentDescription = stringResource(id = R.string.food),
                        modifier = modifier
                )
                Text(text = cost.food.toString())
            }
        }
        if (cost.wood > 0) {
            loadImageResource(R.drawable.wood).resource.resource?.let {
                Image(
                        bitmap = it,
                        contentDescription = stringResource(id = R.string.wood),
                        modifier = modifier
                )
                Text(text = cost.wood.toString())
            }
        }
        if (cost.gold > 0) {
            loadImageResource(R.drawable.gold).resource.resource?.let {
                Image(
                        bitmap = it,
                        contentDescription = stringResource(id = R.string.gold),
                        modifier = modifier
                )
                Text(text = cost.gold.toString())
            }
        }
        if (cost.stone > 0) {
            loadImageResource(R.drawable.stone).resource.resource?.let {
                Image(
                        bitmap = it,
                        contentDescription = stringResource(id = R.string.stone),
                        modifier = modifier
                )
                Text(text = cost.stone.toString())
            }
        }
    }
}

@Preview
@Composable
fun CostComponentPreview() {
    Column {
        CostComponent(cost = Cost(1222,155,1444,1441))
        CostComponent(cost = Cost(1222,155,1444))
        CostComponent(cost = Cost(1222,1441))
        CostComponent(cost = Cost(1441))
    }
}