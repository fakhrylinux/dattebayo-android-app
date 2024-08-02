package id.biz.equatron.dattebayo.core.domain.usecase

import id.biz.equatron.dattebayo.core.data.Resource
import id.biz.equatron.dattebayo.core.domain.model.Character
import id.biz.equatron.dattebayo.core.domain.repository.ICharacterRepository
import kotlinx.coroutines.flow.Flow

class CharacterUseCaseImpl(private val characterRepository: ICharacterRepository) :
    CharacterUseCase {
    override fun getAllCharacter(): Flow<Resource<List<Character>>> =
        characterRepository.getAllCharacter()

    override fun getFavoriteCharacter(): Flow<List<Character>> =
        characterRepository.getFavoriteCharacter()

    override fun setFavoriteCharacter(character: Character, state: Boolean) =
        characterRepository.setFavoriteCharacter(character, state)
}