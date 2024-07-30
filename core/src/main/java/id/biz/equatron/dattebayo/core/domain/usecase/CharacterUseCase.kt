package id.biz.equatron.dattebayo.core.domain.usecase

import id.biz.equatron.dattebayo.core.data.Resource
import id.biz.equatron.dattebayo.core.domain.model.Character
import kotlinx.coroutines.flow.Flow


interface CharacterUseCase {

    fun getAllCharacter(): Flow<Resource<List<Character>>>

    fun getFavoriteCharacter(): Flow<List<Character>>

    fun setFavoriteCharacter(character: Character, state: Boolean)

//    fun getCharacter(id: Int): Flow<Character>
}