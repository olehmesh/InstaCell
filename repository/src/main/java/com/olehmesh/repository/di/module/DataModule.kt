package com.olehmesh.repository.di.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.olehmesh.repository.di.scope.DataScope
import com.olehmesh.repository.InstCellModel
import com.olehmesh.repository.R
import dagger.Module
import dagger.Provides

@Module
class DataModule(var context: Context) {

    @DataScope
    @Provides
    fun provideJson(): Gson {
        return Gson()
    }

    @DataScope
    @Provides
    fun provideDataFromJson(jsonObj: Gson): MutableList<InstCellModel?> {
        val arrayType = object : TypeToken<List<InstCellModel>>() {}.type
        val br =
            context.resources.openRawResource(R.raw.data).bufferedReader()
                .use {
                    it.readText()
                }
        return jsonObj.fromJson(br, arrayType)

    }

}



