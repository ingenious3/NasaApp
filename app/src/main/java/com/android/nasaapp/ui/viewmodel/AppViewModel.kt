package com.android.nasaapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.nasaapp.data.DataEntity
import com.android.nasaapp.data.repository.AppRepositoryImpl
import com.android.nasaapp.network.ResultData
import com.android.nasaapp.utils.Constants
import com.android.nasaapp.utils.States
import kotlinx.coroutines.launch
import javax.inject.Inject

class AppViewModel @Inject constructor(
    private val appRepositoryImpl: AppRepositoryImpl
) : ViewModel() {

    private var _currentState = MutableLiveData<States>()
    var currentState: LiveData<States> = _currentState

    private var _resultGetData = MutableLiveData<DataEntity>()
    var resultGetData: LiveData<DataEntity> = _resultGetData

    private var _errorGetData = MutableLiveData<String>()
    var errorGetData: LiveData<String> = _errorGetData

    fun getData() {

        viewModelScope.launch {
            try {
                when (val response = appRepositoryImpl.getApod(Constants.API_KEY)) {
                    is ResultData.Success -> {
                        _resultGetData.postValue(response.data)
                    }
                    is ResultData.Error -> {
                        _errorGetData.postValue(response.exception.toString())
                    }
                }
            } catch (e: Exception) {
                _errorGetData.postValue(e.message)
            }
        }
    }

    fun setState(state: States) {
        _currentState.postValue(state)
    }

}