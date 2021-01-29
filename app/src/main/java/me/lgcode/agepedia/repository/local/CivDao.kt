package me.lgcode.agepedia.repository.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CivDao {

    @Query("SELECT * FROM civs")
    fun getAll(): DataSource.Factory<Int, CivEntity>

    @Query("SELECT * FROM civs WHERE id=:id")
    fun getOne(id: Int): CivEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(civs: List<CivEntity>)

}