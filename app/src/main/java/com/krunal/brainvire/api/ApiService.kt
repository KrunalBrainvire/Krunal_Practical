package com.krunal.brainvire.api

import com.krunal.brainvire.api.response.UserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("api/")
    fun getMenu(@Query("page") strPage: String,@Query("results") strResults: String): Single<UserResponse>

}