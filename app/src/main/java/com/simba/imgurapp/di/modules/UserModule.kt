package com.simba.imgurapp.di.modules

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.simba.imgurapp.BuildConfig
import com.simba.imgurapp.data.DefaultUserRemoteDataSource
import com.simba.imgurapp.data.UserApiService
import com.simba.imgurapp.data.UserRemoteDataSource
import com.simba.imgurapp.data.models.DefaultUserRepository
import com.simba.imgurapp.data.models.UserRepository
import com.simba.imgurapp.utils.ApiEndpoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UserModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    fun provideAuthInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request: Request = chain.request()
            val newRequest = request.newBuilder()
                .addHeader("Authorization", "Client-ID ${BuildConfig.CLIENT_ID}") //Replace you CLIENT_ID here.
                .build()
            chain.proceed(newRequest)
        }
    }

    private val interceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideUserApiService(retrofit: Retrofit): UserApiService {
        return retrofit.create(UserApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: Interceptor, context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS) // connect timeout
            .writeTimeout(60, TimeUnit.SECONDS) // write timeout
            .readTimeout(60, TimeUnit.SECONDS) // read timeout
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideUserApi(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiEndpoint.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideUserRemoteDataSource(userApiService: UserApiService): UserRemoteDataSource {
        return DefaultUserRemoteDataSource(userApiService)
    }

    @Provides
    fun provideUserRepository(
        remoteDataSource: UserRemoteDataSource,
    ): UserRepository {
        return DefaultUserRepository(
            remoteDataSource
        )
    }
}