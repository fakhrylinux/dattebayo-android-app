package id.biz.equatron.dattebayo.core.utils

import id.biz.equatron.dattebayo.core.data.source.local.entity.CharacterEntity
import id.biz.equatron.dattebayo.core.data.source.remote.response.CharactersItem
import id.biz.equatron.dattebayo.core.domain.model.Character
import id.biz.equatron.dattebayo.core.ui.model.UiCharacter

object DataMapper {

    fun mapResponseToEntities(input: List<CharactersItem>): List<CharacterEntity> {
        val characterList = ArrayList<CharacterEntity>()
        input.map {
            val character = CharacterEntity(
                characterId = it.id,
                name = it.name,
                images = it.images,
                jutsu = it.jutsu,
                isFavorite = false,
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
                jutsu = it.jutsu,
                isFavorite = it.isFavorite
            )
        }

    fun mapEntityToDomain(input: CharacterEntity): Character = Character(
        id = input.characterId,
        name = input.name,
        images = input.images,
        jutsu = input.jutsu,
        isFavorite = input.isFavorite
    )

    fun mapDomainToEntity(input: Character) = CharacterEntity(
        characterId = input.id,
        name = input.name,
        images = input.images,
        jutsu = input.jutsu,
        isFavorite = input.isFavorite,
    )

    fun mapDomainToUiModel(input: List<Character>): List<UiCharacter> {
        val characterList = ArrayList<UiCharacter>()
        input.map {
            val character = UiCharacter(
                id = it.id,
                name = it.name,
                images = it.images,
                jutsu = it.jutsu,
                isFavorite = it.isFavorite,
            )
            characterList.add(character)
        }
        return characterList
    }

    fun mapDomainToUiModelSingle(input: Character) = UiCharacter(
        id = input.id,
        name = input.name,
        images = input.images,
        jutsu = input.jutsu,
        isFavorite = input.isFavorite,
    )

    fun mapUiToDomain(input: UiCharacter) = Character(
        id = input.id,
        name = input.name,
        images = input.images,
        jutsu = input.jutsu,
        isFavorite = input.isFavorite
    )
}