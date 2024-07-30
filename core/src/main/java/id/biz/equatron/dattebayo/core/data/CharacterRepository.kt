package id.biz.equatron.dattebayo.core.data

import id.biz.equatron.dattebayo.core.data.source.local.LocalDataSource
import id.biz.equatron.dattebayo.core.data.source.remote.RemoteDataSource
import id.biz.equatron.dattebayo.core.data.source.remote.network.ApiResponse
import id.biz.equatron.dattebayo.core.data.source.remote.response.CharactersItem
import id.biz.equatron.dattebayo.core.domain.model.Character
import id.biz.equatron.dattebayo.core.domain.repository.ICharacterRepository
import id.biz.equatron.dattebayo.core.utils.AppExecutors
import id.biz.equatron.dattebayo.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ICharacterRepository {
    override fun getAllCharacter(): Flow<Resource<List<Character>>> =
        object : NetworkBoundResource<List<Character>, List<CharactersItem>>() {
            override fun loadFromDB(): Flow<List<Character>> {
                return localDataSource.getAllCharacter().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<CharactersItem>>> =
                remoteDataSource.getAllCharacter()
//                    .map Do mapper here

            override suspend fun saveCallResult(data: List<CharactersItem>) {
                val characterList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertCharacter(characterList)
            }

            override fun shouldFetch(data: List<Character>?): Boolean = data.isNullOrEmpty()

        }.asFlow()


    override fun getFavoriteCharacter(): Flow<List<Character>> {
        return localDataSource.getFavoriteCharacter().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteCharacter(character: Character, state: Boolean) {
        val characterEntity = DataMapper.mapDomainToEntity(character)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteCharacter(characterEntity, state)
        }
    }

//    override fun getCharacter(id: Int): Flow<Character> =
//        localDataSource.getCharacter(id).map {
//            Character(
//                id = it.characterId,
//                name = it.name,
//                images = it.images,
//                jutsu = it.jutsu,
//            )
//        }
//            .map {
//            Character(
//                id = it.characterId,
//                name = it.name,
//                images = it.images,
//                jutsu = it.jutsu,
//            )
//        }
}