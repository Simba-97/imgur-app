package com.simba.imgurapp.data.models

import com.simba.imgurapp.data.UserRemoteDataSource
import javax.inject.Inject

interface UserRepository {
    suspend fun getImageSearchByWeekly(queryParams: String): ImageSearchResponse
}

class DefaultUserRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun getImageSearchByWeekly(queryParams: String): ImageSearchResponse {
        return userRemoteDataSource.getImagesWeekly(queryParams)
    }
}