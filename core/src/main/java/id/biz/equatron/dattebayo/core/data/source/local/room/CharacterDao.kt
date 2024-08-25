package id.biz.equatron.dattebayo.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import id.biz.equatron.dattebayo.core.data.source.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    fun getAllCharacter(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM characters where is_favorite = 1")
    fun getFavoriteTourism(): Flow<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCharacterList(characterList: List<CharacterEntity>)

    @Delete
    fun delete(character: CharacterEntity)

    @Update
    fun updateFavoriteCharacter(character: CharacterEntity)

    @Query("SELECT * FROM characters where id = :id")
    suspend fun getCharacter(id: Int): CharacterEntity
}