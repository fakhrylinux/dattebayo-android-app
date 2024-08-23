package id.biz.equatron.dattebayo.di

import id.biz.equatron.dattebayo.character.CharacterViewModel
import id.biz.equatron.dattebayo.core.domain.usecase.CharacterUseCaseImpl
import id.biz.equatron.dattebayo.core.domain.usecase.CharacterUseCase
import id.biz.equatron.dattebayo.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<CharacterUseCase> { CharacterUseCaseImpl(get()) }
}

val viewModelModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}