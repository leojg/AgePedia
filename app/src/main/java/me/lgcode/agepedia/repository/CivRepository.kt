package me.lgcode.agepedia.repository

import androidx.paging.DataSource
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import me.lgcode.agepedia.repository.domain.CivMapper
import me.lgcode.agepedia.repository.domain.CivModel
import me.lgcode.agepedia.repository.local.CivDao
import me.lgcode.agepedia.repository.local.CivEntity
import me.lgcode.agepedia.repository.remote.AgeService

class CivRepository(
    val civDao: CivDao,
    val ageService: AgeService
) {

    fun getCivs(): DataSource.Factory<Int, CivEntity> = civDao.getAll()

    fun getCivsByName(query: String): DataSource.Factory<Int, CivEntity> = civDao.getByName(query)

    suspend fun updateCivs() {
        coroutineScope {
            launch {
                fetchAndInsert()
            }
        }
    }

    private suspend fun fetchAndInsert() {
        val civResponse = ageService.getCivs()
        civResponse.body()!!
        civResponse.body()?.let {response ->
            civDao.insertAll(CivMapper.mapListToEntity(response.civilizations))
        }
    }

}