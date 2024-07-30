package id.biz.equatron.dattebayo.utils

import id.biz.equatron.dattebayo.core.domain.model.Character
import id.biz.equatron.dattebayo.core.ui.model.UiCharacter

object DataMapper {

    fun mapDomainToUiModel(input: List<Character>): List<UiCharacter> {
        val characterList = ArrayList<UiCharacter>()
        input.map {
            val character = UiCharacter(
                id = it.id,
                name = it.name,
//                titles = it.titles,
                images = it.images,
                jutsu = it.jutsu,
            )
            characterList.add(character)
        }
        return characterList
    }
}