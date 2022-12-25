package com.simba.imgurapp.domain

import com.simba.imgurapp.data.models.ImageSearchResponse
import com.simba.imgurapp.data.models.UserRepository
import com.simba.imgurapp.di.modules.component.IoDispatcher
import com.simba.imgurapp.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class SearchImagesByWeeklyUseCase @Inject constructor(
    private val repository: UserRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<String, ImageSearchResponse>(ioDispatcher) {
    override suspend fun execute(parameter: String): ImageSearchResponse {
        return repository.getImageSearchByWeekly(parameter)
    }
}