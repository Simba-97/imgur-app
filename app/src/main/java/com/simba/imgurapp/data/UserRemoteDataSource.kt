package com.simba.imgurapp.data

import com.simba.imgurapp.data.models.ImageSearchResponse

interface UserRemoteDataSource {
    suspend fun getImagesWeekly(queryString: String): ImageSearchResponse
}

class DefaultUserRemoteDataSource(
    private val userApiService: UserApiService
) : UserRemoteDataSource {

    override suspend fun getImagesWeekly(queryString: String): ImageSearchResponse {
        return userApiService.searchImageWeekly(queryString)
    }

}