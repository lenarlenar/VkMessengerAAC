package com.lenarlenar.vkmessengeraac.dagger

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lenarlenar.vkmessengeraac.LocalProfileDataSource
import com.lenarlenar.vkmessengeraac.ProfileDataSource
import com.lenarlenar.vkmessengeraac.RemoteProfileDataSource
import com.lenarlenar.vkmessengeraac.retrofit.UserService
import com.vk.api.sdk.auth.VKAccessToken
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
class RemoteModule{

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, client: OkHttpClient) =
        Retrofit
            .Builder()
            .baseUrl("https://api.vk.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

    @Provides
    @Singleton
    fun provideUserService( retrofit: Retrofit) : UserService = retrofit.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

}