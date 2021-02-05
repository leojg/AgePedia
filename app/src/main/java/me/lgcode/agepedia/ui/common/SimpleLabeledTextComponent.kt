package me.lgcode.agepedia.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SimpleLabeledTextComponent(
        label: String,
        value: String,
        asRow: Boolean = true
) {
    if (asRow) {
        Row(modifier = Modifier.padding(5.dp)) {
            Text(
                    text = label,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(PaddingValues(end = 5.dp))
            )
            Text(
                    text = value,
                    style = MaterialTheme.typography.body1
            )
        }
    } else {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(
                    text = label,
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(PaddingValues(bottom = 5.dp))
            )
            Text(
                    text = value,
                    style = MaterialTheme.typography.body1
            )
        }
    }
}