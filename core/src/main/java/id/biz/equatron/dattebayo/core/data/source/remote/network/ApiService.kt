package id.biz.equatron.dattebayo.core.data.source.remote.network

import id.biz.equatron.dattebayo.core.data.source.remote.response.GetAllCharactersResponse
import retrofit2.http.GET

interface ApiService {

    @GET("characters")
    suspend fun getCharacters(): GetAllCharactersResponse
}