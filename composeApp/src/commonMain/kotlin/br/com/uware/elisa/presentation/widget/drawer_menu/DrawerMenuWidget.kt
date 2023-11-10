package br.com.uware.elisa.presentation.widget.drawer_menu

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import br.com.uware.elisa.Res
import br.com.uware.elisa.presentation.core.main.MainApp
import br.com.uware.elisa.presentation.core.menu.DrawerMenu
import br.com.uware.elisa.presentation.core.menu.DrawerMenuItems
import br.com.uware.elisa.presentation.navigate
import cafe.adriel.voyager.navigator.LocalNavigator
import compose.icons.FeatherIcons
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
                            mainApp.navigate(item)
                        }
                    },
                    selected = mainApp.currentRoute == item.route
                )
            }
        }
        NavigationDrawerItem(
            label = {
                Text(Res.string.back_button)
            },
            onClick = {
                scope.launch {
                    mainApp.drawerState.close()
                    navigator?.pop()
                    mainApp.topBar.setTitle(Res.string.app_name)
                }
            },
            icon = {
                Icon(
                    imageVector = Icons.Rounded.ArrowBackIosNew,
                    contentDescription = Res.string.back_button_description
                )
            },
            selected = false
        )
    }
}