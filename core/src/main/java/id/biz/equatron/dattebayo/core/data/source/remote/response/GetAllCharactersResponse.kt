package id.biz.equatron.dattebayo.core.data.source.remote.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class GetAllCharactersResponse(

    @Keep
    @field:SerializedName("characters")
    val characters: List<CharactersItem>,

    @Keep
    @field:SerializedName("total")
    val total: Int,

    @Keep
    @field:SerializedName("pageSize")
    val pageSize: Int,

    @Keep
    @field:SerializedName("currentPage")
    val currentPage: Int
)
