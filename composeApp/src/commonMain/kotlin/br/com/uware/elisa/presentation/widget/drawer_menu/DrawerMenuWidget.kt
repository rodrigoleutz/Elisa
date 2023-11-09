package br.com.uware.elisa.presentation.widget.drawer_menu

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import br.com.uware.elisa.presentation.core.main.MainApp
import br.com.uware.elisa.presentation.core.menu.DrawerMenu
import br.com.uware.elisa.presentation.core.menu.DrawerMenuItems
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlinx.coroutines.launch

@Composable
fun DrawerMenuWidget(
    mainApp: MainApp,
    menu: DrawerMenu
) {
    val scope = rememberCoroutineScope()
    val navigator = LocalNavigator.current
    ModalDrawerSheet {
        LazyColumn {
            items(menu.all) { item ->
                NavigationDrawerItem(
                    label = {
                        Text(item.label)
                    },
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = item.description)
                    },
                    onClick = {
                        scope.launch {
                            mainApp.drawerState.close()
                            navigator?.push(item.route)
                        }
                    },
                    selected = mainApp.currentRoute == item.route
                )
            }
        }
    }
}