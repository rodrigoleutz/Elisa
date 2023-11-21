package br.com.uware.elisa.presentation.screen.games.math

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import br.com.uware.elisa.presentation.core.main.MainApp
import br.com.uware.elisa.presentation.core.menu.MenuItem
import br.com.uware.elisa.presentation.theme.Dimension
import br.com.uware.elisa.presentation.theme.Font
import cafe.adriel.voyager.navigator.LocalNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MathCard(
    mainApp: MainApp,
    menuItem: MathLevelModel
) {
    val navigator = LocalNavigator.current
    ElevatedCard(
        onClick = {
            navigator?.push(MathGameScreen(menuItem.level))
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
            Text(
                text = menuItem.name,
                fontSize = Font.big,
                fontWeight = FontWeight.Bold
            )
        }
    }
}