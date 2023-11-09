package br.com.uware.elisa.di.presentation

import br.com.uware.elisa.presentation.core.state.loading.LoadingState
import br.com.uware.elisa.presentation.core.state.loading.LoadingStateImpl
import br.com.uware.elisa.presentation.core.state.top_bar.TopBarWidgetState
import br.com.uware.elisa.presentation.core.state.top_bar.TopBarWidgetStateImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val stateModule = module {
    singleOf(::LoadingStateImpl) bind LoadingState::class
    singleOf(::TopBarWidgetStateImpl) bind TopBarWidgetState::class
}