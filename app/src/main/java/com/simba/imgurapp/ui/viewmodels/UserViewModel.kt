package com.simba.imgurapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simba.imgurapp.data.models.ImageItemDetails
import com.simba.imgurapp.domain.SearchImagesByWeeklyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.simba.imgurapp.utils.*
import javax.inject.Inject

//ViewModel of the MVVM architecture
//Define all lifecycle aware ui related functions here.
@HiltViewModel
class UserViewModel @Inject constructor(
    private val searchImagesByWeeklyUseCase: SearchImagesByWeeklyUseCase
) : ViewModel() {
    private var _uiState = MutableStateFlow(UserUiState())
    val uiState: StateFlow<UserUiState> = _uiState

    fun onTriggerEvent(event: UserSearchEvent) {
        when (event) {
            is UserSearchEvent.SearchImagesByWeek -> searchImagesByWeek(event.params)
        }
    }

    private fun searchImagesByWeek(params: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isDataLoading = true) }
            when (val result = searchImagesByWeeklyUseCase(params)) {
                Result.Loading -> {
                    _uiState.update { it.copy(isDataLoading = true) }
                }
                is Result.Success -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            status = result.data.status!!,
                            success = result.data.success!!,
                            data = result.data.data
                        )
                    }
                }
                is Result.Error -> {
                    _uiState.update {
                        it.copy(
                            isDataLoading = false,
                            message = "Something went wrong! Please try again."
                        )
                    }
                }
            }
        }
    }
}

data class UserUiState(
    val status: Int? = null,
    val success: Boolean = false,
    val isDataLoading: Boolean = false,
    val data: List<ImageItemDetails>? = null,
    val message: String? = null
)

sealed class UserSearchEvent {
    data class SearchImagesByWeek(val params: String) : UserSearchEvent()
}