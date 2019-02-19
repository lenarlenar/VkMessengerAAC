package com.lenarlenar.vkmessengeraac

import com.lenarlenar.vkmessengeraac.model.ProfileResponse
import com.lenarlenar.vkmessengeraac.model.VkProfile
import com.lenarlenar.vkmessengeraac.retrofit.UserService
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthResult
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import javax.inject.Inject

class RemoteProfileDataSource @Inject constructor(private val userService: UserService, val accessToken: VKAccessToken) : ProfileDataSource{

    override fun getUserName(): Single<String> =
        userService.requestProfile(accessToken.accessToken, VK.getApiVersion())
        .map { (it.body() as ProfileResponse).profileDetails[0].first_name }
        .subscribeOn(Schedulers.io())
}