package me.lgcode.agepedia.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [CivEntity::class, TechEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AgeDatabase: RoomDatabase() {
    abstract fun civDao(): CivDao
    abstract fun techDao(): TechDao
}