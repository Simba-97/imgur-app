package com.simba.imgurapp

import android.app.Application
import com.simba.imgurapp.di.modules.component.AppComponent
import dagger.hilt.EntryPoints
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ImgurApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        component().inject(this)
    }

    fun component(): AppComponent {
        return EntryPoints.get(this, AppComponent::class.java)
    }

    companion object {
        @get:Synchronized
        lateinit var instance: ImgurApp
    }
}