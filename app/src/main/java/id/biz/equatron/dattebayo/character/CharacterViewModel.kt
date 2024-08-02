package id.biz.equatron.dattebayo.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.biz.equatron.dattebayo.core.domain.usecase.CharacterUseCase

class CharacterViewModel(characterUseCase: CharacterUseCase) : ViewModel() {
    val characterList = characterUseCase.getAllCharacter().asLiveData()
}