package com.lenarlenar.vkmessengeraac

import com.lenarlenar.vkmessengeraac.model.ProfileResponse
import io.reactivex.Single

interface ProfileDataSource {
    fun getUserName(): Single<String>
}

interface ProfileRepository: ProfileDataSource