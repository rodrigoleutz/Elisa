package br.com.uware.elisa.presentation

import br.com.uware.elisa.presentation.core.main.MainApp
import br.com.uware.elisa.presentation.core.menu.MenuItem


fun MainApp.navigate(menuItem: MenuItem) {
    this.topBar.setTitle(menuItem.label)
}