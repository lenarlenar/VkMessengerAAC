package com.lenarlenar.vkmessengeraac.dagger

import com.lenarlenar.vkmessengeraac.ProfileFragment
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent{
    fun inject(fragment: ProfileFragment)
}