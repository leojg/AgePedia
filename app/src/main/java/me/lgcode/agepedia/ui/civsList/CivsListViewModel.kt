package me.lgcode.agepedia.ui.civsList

import androidx.compose.runtime.mutableStateOf
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.launch
import me.lgcode.agepedia.repository.CivRepository

class CivsListViewModel @ViewModelInject constructor(
    val civRepository: CivRepository
): ViewModel() {

    val queryLiveData = MutableLiveData("")

    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setPageSize(15)
        .build()

    private val civsLiveData = Transformations.switchMap(queryLiveData) {
        if (it.isNullOrEmpty()) {
            LivePagedListBuilder(civRepository.getCivs(), config).build()
        } else {
            LivePagedListBuilder(civRepository.getCivsByName(it), config).build()
        }
    }

    fun civs() = civsLiveData

    fun fetchCivs() {
        viewModelScope.launch {
            civRepository.updateCivs()
        }
    }

    fun updateQuery(query: String) {
        queryLiveData.postValue(query)
    }

}