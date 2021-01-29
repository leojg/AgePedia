package me.lgcode.agepedia.repository.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.lgcode.agepedia.repository.domain.CivModel

@Entity(tableName = "civs")
class CivEntity(
    @PrimaryKey override val id: Int,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "expansion") override val expansion: String,
    @ColumnInfo(name = "type") override val type: String,
    @ColumnInfo(name = "uniqueUnits") override val uniqueUnits: List<String>,
    @ColumnInfo(name = "uniqueTechs") override val uniqueTechs: List<String>,
    @ColumnInfo(name = "teamBonus") override val teamBonus: String,
    @ColumnInfo(name = "civBonus") override val civBonus: List<String>
) : CivModel