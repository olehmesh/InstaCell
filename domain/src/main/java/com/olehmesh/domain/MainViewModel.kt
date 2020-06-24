package com.olehmesh.domain

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.olehmesh.repository.InstCellModel
import kotlinx.coroutines.*


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val data = MutableLiveData<List<InstCellModel>>()
    var context: Context = getApplication()
    private val jsonObj = Gson()
    private val scope = CoroutineScope(Job())
    private val arrayType = object : TypeToken<List<InstCellModel>>() {}.type

    init {
        getRawData()
    }

    private fun getRawData() {

        scope.launch(Dispatchers.Main) {
                val br =
                    context.resources.openRawResource(R.raw.data).bufferedReader()
                        .use { it.readText() }
                data.value = jsonObj.fromJson(br, arrayType)
        }
    }

    fun getData(): MutableLiveData<List<InstCellModel>> = data

}




