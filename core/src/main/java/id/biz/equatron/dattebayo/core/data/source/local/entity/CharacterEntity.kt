package id.biz.equatron.dattebayo.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var characterId: Int,

    var name: String,

//    var titles: List<String>,

    var images: List<String>,

    var jutsu: List<String>,


    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean = false
)
