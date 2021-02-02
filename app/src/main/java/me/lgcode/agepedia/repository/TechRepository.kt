package me.lgcode.agepedia.repository

import androidx.paging.DataSource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import me.lgcode.agepedia.repository.domain.CivMapper
import me.lgcode.agepedia.repository.domain.TechMapper
import me.lgcode.agepedia.repository.local.CivEntity
import me.lgcode.agepedia.repository.local.TechDao
import me.lgcode.agepedia.repository.local.TechEntity
import me.lgcode.agepedia.repository.remote.TechService

class TechRepository(
    val techDao: TechDao,
    val techService: TechService
) {

    fun getTechs(): DataSource.Factory<Int, TechEntity> = techDao.getAll()
    fun getTechsByName(query: String): DataSource.Factory<Int, TechEntity> = techDao.getByName(query)

    suspend fun updateTechs() {
        coroutineScope {
            launch {
                fetchAndInsert()
            }
        }
    }

    private suspend fun fetchAndInsert() {
        val civResponse = techService.getTechs()
        civResponse.body()?.let {response ->
            techDao.insertAll(TechMapper.mapListToEntity(response.technologies))
        }
    }

}