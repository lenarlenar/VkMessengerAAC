package com.lenarlenar.vkmessengeraac

import com.lenarlenar.vkmessengeraac.model.ProfileResponse
import com.lenarlenar.vkmessengeraac.model.VkProfile
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class ProfileRepositoryImpl @Inject constructor(
      private val localDataSource: ProfileDataSource
      ,private val remoteDataSource: ProfileDataSource
) : ProfileRepository {

    override fun getUserName() : Single<String>
    {
        return remoteDataSource.getUserName()
    }
}
