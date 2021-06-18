package com.krunal.brainvire.ui.fragment.userList

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krunal.brainvire.api.ApiState
import com.krunal.brainvire.api.response.UserResponse
import com.krunal.brainvire.api.repository.MainRepository

class UserViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    fun getMenu(
        strPage: String,
        strResults: String): MutableLiveData<ApiState<UserResponse>> {
        return mainRepository.getMenu(strPage,strResults)
    }
}