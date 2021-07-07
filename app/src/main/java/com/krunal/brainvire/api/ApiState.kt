package com.krunal.brainvire.api

import com.krunal.brainvire.api.response.UserResponse


data class ApiState<out T>(val ApiStatus: APIStatus, val data: T?, val error: String?) {

    companion object {
        fun <T> success(data: T?): ApiState<T> =
            ApiState(ApiStatus = APIStatus.SUCCESS, data = data, error = null)

        fun <T> error(error:String): ApiState<T> =
            ApiState(ApiStatus = APIStatus.ERROR, data = null, error = error)

        fun <T> loading(): ApiState<T> =
            ApiState(ApiStatus = APIStatus.LOADING, data = null, error = null)
    }

}
