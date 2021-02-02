package me.lgcode.agepedia.repository.local

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import me.lgcode.agepedia.repository.domain.Age
import me.lgcode.agepedia.repository.domain.Expansion

class Converters {

    @TypeConverter
    fun fromList(value: List<String>?) = Json.encodeToString(value)

    @TypeConverter
    fun toList(value: String?) = if (value.isNullOrEmpty().not()) Json.decodeFromString<List<String>>(value!!) else emptyList()

    @TypeConverter
    fun fromExpansionEnum(expansion: Expansion) = expansion.name

    @TypeConverter
    fun toExpansionEnum(expansion: String) = enumValueOf<Expansion>(expansion)

    @TypeConverter
    fun fromAgeEnum(age: Age) = age.name

    @TypeConverter
    fun toAgeEnum(age: String) = enumValueOf<Age>(age)

}