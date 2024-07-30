package id.biz.equatron.dattebayo.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.biz.equatron.dattebayo.core.data.Resource
import id.biz.equatron.dattebayo.core.domain.usecase.CharacterUseCase
import id.biz.equatron.dattebayo.utils.DataMapper
import kotlinx.coroutines.flow.map

class CharacterViewModel(characterUseCase: CharacterUseCase) : ViewModel() {
    val characterList = characterUseCase.getAllCharacter().asLiveData()

    // LiveData<Resource<List<Character>>>

//    val characterList = characterUseCase.getAllCharacter()
//        .map {
//            it.data?.let { characterList ->
//                Resource.Success(DataMapper.mapDomainToUiModel(characterList))
//            }
//        }.asLiveData()

}