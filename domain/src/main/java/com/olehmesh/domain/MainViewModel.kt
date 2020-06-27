package com.olehmesh.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.olehmesh.repository.models.InstCellModel
import com.olehmesh.repository.PaginationDataSource
import kotlinx.coroutines.*


class MainViewModel : ViewModel() {

    private var liveData: LiveData<PagedList<InstCellModel>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()

        liveData = initPagedList(config).build()

    }

    fun getData(): LiveData<PagedList<InstCellModel>> = liveData


    private fun initPagedList(config: PagedList.Config): LivePagedListBuilder<String, InstCellModel> {

        val dataSourceFactory = object : DataSource.Factory<String, InstCellModel>() {

            override fun create(): DataSource<String, InstCellModel> {

                return PaginationDataSource(Dispatchers.IO)

            }
        }

        return LivePagedListBuilder(dataSourceFactory, config)

    }

}
