package br.com.uware.elisa.presentation.screen.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import br.com.uware.elisa.presentation.component.card.CardComponent
import br.com.uware.elisa.presentation.component.layout.CenterColumnComponent
import br.com.uware.elisa.presentation.core.main.MainApp
import br.com.uware.elisa.presentation.core.main.MainScreen
import br.com.uware.elisa.presentation.core.menu.DrawerMenuItems
import cafe.adriel.voyager.core.screen.Screen

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        MainScreen { mainApp: MainApp ->
            CenterColumnComponent {
                LazyColumn {
                    items(DrawerMenuItems().all) { item ->
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