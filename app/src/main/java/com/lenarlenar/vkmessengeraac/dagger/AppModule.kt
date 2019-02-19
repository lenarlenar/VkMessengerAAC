package com.lenarlenar.vkmessengeraac.dagger

import android.app.Application
import android.content.Context
import com.lenarlenar.vkmessengeraac.*
import com.lenarlenar.vkmessengeraac.retrofit.UserService
import com.vk.api.sdk.auth.VKAccessToken
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = arrayOf(RemoteModule::class))
class AppModule(private val app: Application){

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideProfileViewModelFactory(app: Application, repository: ProfileDataSource) = ProfileViewModelFactory(app, repository)

    @Provides
    @Singleton
    fun provideProfileRepository(@Named("local")local: ProfileDataSource, @Named("remote")remote: ProfileDataSource)
          : ProfileRepository = ProfileRepositoryImpl(local, remote)

    @Named("local")
    @Provides
    @Singleton
    fun provideLocalDataSource(): ProfileDataSource = LocalProfileDataSource()

    @Named("remote")
    @Provides
    @Singleton
    fun provideRemoteDataSource(userService: UserService, accessToken: VKAccessToken): ProfileDataSource
            = RemoteProfileDataSource(userService, accessToken)

    @Provides
    fun provideVkAccessToken(context: Context) : VKAccessToken{
        val sharedPreference= context.getSharedPreferences("com.vkontakte.android_pref_name"
            , Context.MODE_PRIVATE)
        return VKAccessToken.restore(sharedPreference)!!
    }
}