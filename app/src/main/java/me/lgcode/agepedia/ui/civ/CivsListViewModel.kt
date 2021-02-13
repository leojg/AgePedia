package me.lgcode.agepedia.ui.civ

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.launch
import me.lgcode.agepedia.repository.CivRepository
import me.lgcode.agepedia.repository.local.CivEntity
import me.lgcode.agepedia.ui.BaseViewModel

class CivsListViewModel @ViewModelInject constructor(
    val civRepository: CivRepository
): BaseViewModel<CivEntity>() {

    override val resultsLiveData = Transformations.switchMap(queryLiveData) {
        if (it.isNullOrEmpty()) {
            LivePagedListBuilder(civRepository.getCivs(), config).build()
        } else {
            LivePagedListBuilder(civRepository.getCivsByName(it), config).build()
        }
    }

    override fun fetchResults() {
        viewModelScope.launch {
            civRepository.updateCivs()
        }
    }

}