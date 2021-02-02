package me.lgcode.agepedia.repository.local

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.lgcode.agepedia.repository.domain.Age
import me.lgcode.agepedia.repository.domain.Cost
import me.lgcode.agepedia.repository.domain.Expansion
import me.lgcode.agepedia.repository.domain.TechModel

@Entity(tableName = "techs")
class TechEntity(
    @PrimaryKey override val id: Int,
    @ColumnInfo(name = "name") override val name: String,
    @ColumnInfo(name = "description") override val description: String,
    @ColumnInfo(name = "expansion") override val expansion: Expansion,
    @ColumnInfo(name = "age") override val age: Age,
    @ColumnInfo(name = "developsIn") override val developsIn: String,
    @Embedded override val cost: Cost,
    @ColumnInfo(name = "buildTime") override val buildTime: Int,
    @ColumnInfo(name = "appliesTo") override val appliesTo: List<String>?
) : TechModel