package com.olehmesh.repository

import androidx.paging.ItemKeyedDataSource
import com.olehmesh.repository.di.App
import com.olehmesh.repository.models.InstCellModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class PaginationDataSource(context: CoroutineContext) :
    ItemKeyedDataSource<String, InstCellModel>() {

    private val job = Job()
    private val scope = CoroutineScope(context + job)

    @Inject
    lateinit var data: MutableList<InstCellModel?>

    init {
        App.component.inject(this)
    }

    override fun loadInitial(
        params: LoadInitialParams<String?>,
        callback: LoadInitialCallback<InstCellModel?>
    ) {

        scope.launch {
            callback.onResult(data)
            params.requestedLoadSize
        }

    }

    override fun loadAfter(params: LoadParams<String?>, callback: LoadCallback<InstCellModel?>) {
        scope.launch {
            callback.onResult(data)
        }
    }

    override fun loadBefore(params: LoadParams<String?>, callback: LoadCallback<InstCellModel?>) {
        // leave empty (scroll from top to down)
    }

    override fun getKey(item: InstCellModel): String {
        return item.id.toString()
    }

}