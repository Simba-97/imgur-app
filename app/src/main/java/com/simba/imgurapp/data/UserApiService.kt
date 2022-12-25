package com.simba.imgurapp.data

import com.simba.imgurapp.data.models.ImageSearchResponse
import com.simba.imgurapp.utils.ApiEndpoint
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {

    @GET(ApiEndpoint.ENDPOINT_SEARCH)
    suspend fun searchImageWeekly(@Query("q") queryString: String): ImageSearchResponse
}