package com.lenarlenar.vkmessengeraac
import android.app.Application
import com.lenarlenar.vkmessengeraac.dagger.AppComponent
import com.lenarlenar.vkmessengeraac.dagger.AppModule
import com.lenarlenar.vkmessengeraac.dagger.DaggerAppComponent
import com.vk.api.sdk.auth.VKAccessToken
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : Application(){
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}