package com.example.thenamegame.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thenamegame.data.TheNameGameRepository
import com.example.thenamegame.data.TheNameResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TheViewModel(val repository: TheNameGameRepository) : ViewModel() {

    private val _UiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _UiState.asStateFlow()


    init {
        getAllEmp()
    }

    fun getAllEmp() {
        viewModelScope.launch {
            _UiState.update {
                it.copy(isLoading = true)
            }
            repository.getAllEmpl().onEach { listNameResponse ->
                _UiState.update {
                    it.copy(employes = listNameResponse, isLoading = false)
                }

            }
        }
    }
}

data class HomeUiState(
    val isLoading: Boolean = false,
    val employes: List<TheNameResponse> = listOf(),
    val isError: Boolean = false
)