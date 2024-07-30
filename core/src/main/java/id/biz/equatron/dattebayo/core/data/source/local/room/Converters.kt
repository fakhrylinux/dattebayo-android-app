package id.biz.equatron.dattebayo.core.data.source.local.room

import androidx.room.TypeConverter
import com.google.gson.Gson

// Taken from https://stackoverflow.com/questions/44986626/android-room-database-how-to-handle-arraylist-in-an-entity

class Converters {

    @TypeConverter
    fun listToJson(value: List<String>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}