package com.lenarlenar.vkmessengeraac.retrofit

import com.lenarlenar.vkmessengeraac.model.ProfileResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService{

    @GET("/method/users.get")
    fun requestProfile(@Query("access_token") token: String, @Query("version") version: String): Single<Response<ProfileResponse>>
}