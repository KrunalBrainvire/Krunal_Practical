package com.krunal.brainvire.api.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.krunal.brainvire.api.ApiService
import com.krunal.brainvire.api.ApiState
import com.krunal.brainvire.api.response.UserResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers.io
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) :
    BaseRepository() {


    fun getMenu(
        strPage: String,
        strResults: String
    ): MutableLiveData<ApiState<UserResponse>> {
        val data: MutableLiveData<ApiState<UserResponse>> =
            MutableLiveData()

        try {

            data.value = ApiState.loading();
            disposable.add(
                apiService.getMenu(
                    strPage,
                    strResults
                ).subscribeOn(io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<UserResponse>() {
                        override fun onSuccess(t: UserResponse) {
                            Log.e("TAG", "onSuccess: ")

                            data.value = ApiState.success(t)
                        }

                        override fun onError(e: Throwable) {
                            data.value = ApiState.error(e.toString())
                        }

                    })
            )

        } catch (e: Exception) {
            e.stackTrace
        }

        return data
    }

    suspend fun getUser(
        strPage: String,
        strResults: String
    ): ApiState<UserResponse> {

        return ApiState.success(
            apiService.getUser(
                strPage,
                strResults
            )
        )

    }


}