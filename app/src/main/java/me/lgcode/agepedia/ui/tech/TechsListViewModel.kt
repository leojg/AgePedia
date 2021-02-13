package me.lgcode.agepedia.ui.tech

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.launch
import me.lgcode.agepedia.repository.TechRepository
import me.lgcode.agepedia.repository.domain.TechModel
import me.lgcode.agepedia.repository.local.TechEntity
import me.lgcode.agepedia.ui.BaseViewModel

class TechsListViewModel @ViewModelInject constructor(
    val techRepository: TechRepository
): BaseViewModel<TechEntity>() {

    override val resultsLiveData = Transformations.switchMap(queryLiveData) {
        if (it.isNullOrEmpty()) {
            LivePagedListBuilder(techRepository.getTechs(), config).build()
        } else {
            LivePagedListBuilder(techRepository.getTechsByName(it), config).build()
        }
    }

    override fun fetchResults() {
        viewModelScope.launch {
            techRepository.getTechs()
        }
    }


}