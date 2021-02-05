package me.lgcode.agepedia.ui.tech

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.launch
import me.lgcode.agepedia.repository.TechRepository

class TechsListViewModel @ViewModelInject constructor(
    val techRepository: TechRepository
): ViewModel() {
    val queryLiveData = MutableLiveData("")

    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setPageSize(15)
        .build()

    private val techsLiveData = Transformations.switchMap(queryLiveData) {
        if (it.isNullOrEmpty()) {
            LivePagedListBuilder(techRepository.getTechs(), config).build()
        } else {
            LivePagedListBuilder(techRepository.getTechsByName(it), config).build()
        }
    }

    fun techs() = techsLiveData

    fun fetchTechs() {
        viewModelScope.launch {
            techRepository.updateTechs()
        }
    }

    fun updateQuery(query: String) {
        queryLiveData.postValue(query)
    }

}