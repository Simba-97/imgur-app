package com.simba.imgurapp.di.modules.component

import com.simba.imgurapp.ImgurApp
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@EntryPoint
interface AppComponent {
    fun inject(app: ImgurApp?)
}