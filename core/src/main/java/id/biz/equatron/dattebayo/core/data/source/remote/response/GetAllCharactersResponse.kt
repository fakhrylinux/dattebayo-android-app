package id.biz.equatron.dattebayo.core.data.source.remote.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class GetAllCharactersResponse(

    @field:SerializedName("characters")
    val characters: List<CharactersItem>,

    @field:SerializedName("total")
    val total: Int,

    @field:SerializedName("pageSize")
    val pageSize: Int,

    @field:SerializedName("currentPage")
    val currentPage: Int
)
