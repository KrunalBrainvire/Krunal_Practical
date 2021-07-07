package com.krunal.brainvire.ui.fragment.userList

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.krunal.brainvire.api.ApiState
import com.krunal.brainvire.api.response.UserResponse
import com.krunal.brainvire.api.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class UserViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private val job = SupervisorJob()
    val coroutineContext = Dispatchers.Main + job

    val data: MutableLiveData<ApiState<UserResponse>> = MutableLiveData()

    fun getMenu(
        strPage: String,
        strResults: String
    ): MutableLiveData<ApiState<UserResponse>> {
        return mainRepository.getMenu(strPage, strResults)
    }

    fun callLectureAPI(
        strPage: String,
        strResults: String) {
        viewModelScope.launch(coroutineContext) {
            data.value = ApiState.loading()
            data.value =
                mainRepository.getUser(strPage, strResults)
        }
    }

}