package br.com.uware.elisa.presentation.screen.games

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import br.com.uware.elisa.presentation.component.card.CardComponent
import br.com.uware.elisa.presentation.component.layout.CenterColumnComponent
import br.com.uware.elisa.presentation.core.main.MainApp
import br.com.uware.elisa.presentation.core.main.MainScreen
import br.com.uware.elisa.presentation.core.menu.DrawerMenuGamesItems
import cafe.adriel.voyager.core.screen.Screen

class GamesScreen : Screen {

    @Composable
    override fun Content() {
        MainScreen { mainApp: MainApp ->
            CenterColumnComponent {
                LazyColumn {
                    items(DrawerMenuGamesItems().all) {item ->
                        CardComponent(
                            mainApp = mainApp,
                            menuItem = item
                        )
                    }
                }
            }
        }
    }
}