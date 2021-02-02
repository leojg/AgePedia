package me.lgcode.agepedia.repository.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TechDao {

    @Query("SELECT * FROM techs")
    fun getAll(): DataSource.Factory<Int, TechEntity>

    @Query("SELECT * FROM techs WHERE id=:id")
    fun getOne(id: Int): TechEntity

    @Query("SELECT * FROM techs WHERE name LIKE '%' || :name || '%'")
    fun getByName(name: String): DataSource.Factory<Int, TechEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(techs: List<TechEntity>)

}