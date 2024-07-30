package id.biz.equatron.dattebayo.core.utils

import id.biz.equatron.dattebayo.core.data.source.local.entity.CharacterEntity
import id.biz.equatron.dattebayo.core.data.source.remote.response.CharactersItem
import id.biz.equatron.dattebayo.core.domain.model.Character

object DataMapper {

    fun mapResponseToEntities(input: List<CharactersItem>): List<CharacterEntity> {
        val characterList = ArrayList<CharacterEntity>()
        input.map {
            val character = CharacterEntity(
                characterId = it.id,
                name = it.name,
                images = it.images,
                jutsu = it.jutsu,
//                titles = it.personal.titles
            )
            characterList.add(character)
        }
        return characterList
    }

    fun mapEntitiesToDomain(input: List<CharacterEntity>): List<Character> =
        input.map {
            Character(
                id = it.characterId,
                name = it.name,
                images = it.images,
//                titles = it.titles,
                jutsu = it.jutsu,
            )
        }

    fun mapDomainToEntity(input: Character) = CharacterEntity(
        characterId = input.id,
        name = input.name,
        images = input.images,
        jutsu = input.jutsu,
//        titles = input.titles,
    )


}