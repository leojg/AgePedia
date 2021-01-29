package me.lgcode.agepedia.ui.civsList

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.launch
import me.lgcode.agepedia.repository.CivRepository

class CivsListViewModel @ViewModelInject constructor(
    val civRepository: CivRepository
): ViewModel() {

    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setPageSize(15)
        .build()

    private val civsLiveData by lazy {
        LivePagedListBuilder(civRepository.getCivs(), config).build()
    }

    fun civs() = civsLiveData

    fun fetchCivs() {
        viewModelScope.launch {
            civRepository.updateCivs()
        }
    }

}