package me.lgcode.agepedia.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList

abstract class BaseViewModel<T>: ViewModel() {
    val queryLiveData = MutableLiveData("")

    open val config = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setPageSize(15)
        .build()

    abstract val resultsLiveData: LiveData<PagedList<T>>

    fun results() = resultsLiveData

    abstract fun fetchResults()

    fun updateQuery(query: String) {
        queryLiveData.postValue(query)
    }
}