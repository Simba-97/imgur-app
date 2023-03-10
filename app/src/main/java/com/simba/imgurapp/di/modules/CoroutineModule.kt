package com.simba.imgurapp.di.modules

import com.simba.imgurapp.di.modules.component.DefaultDispatcher
import com.simba.imgurapp.di.modules.component.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CoroutineModule {

    @IoDispatcher
    @Singleton
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @DefaultDispatcher
    @Singleton
    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}