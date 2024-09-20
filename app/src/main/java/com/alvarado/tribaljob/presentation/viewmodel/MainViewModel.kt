package com.alvarado.tribaljob.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvarado.tribaljob.data.api.ApiMethods
import com.alvarado.tribaljob.presentation.viewmodel.states.MainStateResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiService: ApiMethods
): ViewModel() {
    val categories = MutableLiveData<List<String>>()
    val state = MutableLiveData<MainStateResult>(MainStateResult.Loading)

    fun getCategories() {
        viewModelScope.launch {
            try {
                val response = apiService.getCategories()
                if (response.isSuccessful) {
                    categories.postValue(response.body())
                    response.body()?.let { state.postValue(MainStateResult.Success(it)) }
                } else {
                    state.postValue(MainStateResult.Error("Error"))
                }
            } catch (e: Exception) {
                e.printStackTrace()
                state.postValue(MainStateResult.Error(e.message ?: "Error"))
            }
        }
    }
}