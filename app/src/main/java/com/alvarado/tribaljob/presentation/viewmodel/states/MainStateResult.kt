package com.alvarado.tribaljob.presentation.viewmodel.states

sealed class MainStateResult {
    data class Success(val data: List<String>): MainStateResult()
    data class Error(val message: String) : MainStateResult()
    data object Loading : MainStateResult()
}