package br.com.uware.elisa.presentation.component.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.uware.elisa.presentation.theme.Dimension
import br.com.uware.elisa.presentation.theme.Font
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardComponent(
    label: String,
    icon: ImageVector,
    route: Screen
){
    val navigator = LocalNavigator.current
    ElevatedCard(
        onClick = {
            navigator?.push(route)
        },
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = Dimension.big,
            pressedElevation = Dimension.none
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        modifier = Modifier.fillMaxWidth().padding(Dimension.giant)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(Dimension.giant),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label
            )
            Text(
                text = label,
                fontSize = Font.big
            )
        }
    }
}