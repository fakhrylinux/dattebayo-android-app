package id.biz.equatron.dattebayo.core.data.source.remote

import android.util.Log
import id.biz.equatron.dattebayo.core.data.source.remote.network.ApiResponse
import id.biz.equatron.dattebayo.core.data.source.remote.network.ApiService
import id.biz.equatron.dattebayo.core.data.source.remote.response.CharactersItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllCharacter(): Flow<ApiResponse<List<CharactersItem>>> {
        return flow {
            try {
                val response = apiService.getCharacters()
                val dataArray = response.characters
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}