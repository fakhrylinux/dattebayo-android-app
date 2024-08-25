package id.biz.equatron.dattebayo.detail

import androidx.lifecycle.ViewModel
import id.biz.equatron.dattebayo.core.domain.usecase.CharacterUseCase
import id.biz.equatron.dattebayo.core.ui.model.UiCharacter
import id.biz.equatron.dattebayo.core.utils.DataMapper

class DetailViewModel(private val characterUseCase: CharacterUseCase) : ViewModel() {
    fun setFavoriteCharacter(character: UiCharacter, newStatus: Boolean) {
        characterUseCase.setFavoriteCharacter(DataMapper.mapUiToDomain(character), newStatus)
    }

    suspend fun getCharacter(characterId: Int): UiCharacter =
        DataMapper.mapDomainToUiModelSingle(characterUseCase.getCharacter(characterId))
}