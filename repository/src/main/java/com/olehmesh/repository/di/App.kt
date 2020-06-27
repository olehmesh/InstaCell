package com.olehmesh.repository.di

import android.app.Application
import com.olehmesh.repository.di.component.AppComponent
import com.olehmesh.repository.di.component.DaggerAppComponent
import com.olehmesh.repository.di.module.DataModule

class App : Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .dataModule(DataModule(this))
            .build()
    }

}