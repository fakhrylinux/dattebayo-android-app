package id.biz.equatron.dattebayo.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.biz.equatron.dattebayo.core.domain.usecase.CharacterUseCase

class FavoriteViewModel(characterUseCase: CharacterUseCase) : ViewModel() {
    val favoriteCharacters = characterUseCase.getFavoriteCharacter().asLiveData()
}