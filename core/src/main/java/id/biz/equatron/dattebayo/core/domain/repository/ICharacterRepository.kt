package id.biz.equatron.dattebayo.core.domain.repository

import id.biz.equatron.dattebayo.core.data.Resource
import id.biz.equatron.dattebayo.core.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface ICharacterRepository {

    fun getAllCharacter(): Flow<Resource<List<Character>>>

    fun getFavoriteCharacter(): Flow<List<Character>>

    fun setFavoriteCharacter(character: Character, state: Boolean)

    suspend fun getCharacter(id: Int): Character
}