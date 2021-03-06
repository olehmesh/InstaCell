package com.olehmesh.repository.di.component

import com.olehmesh.repository.di.module.DataModule
import com.olehmesh.repository.di.scope.DataScope
import com.olehmesh.repository.PaginationDataSource
import dagger.Component

@DataScope
@Component(modules = [DataModule::class])
interface AppComponent {

    fun inject(paginationDataSource: PaginationDataSource)

}