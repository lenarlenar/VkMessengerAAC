package com.lenarlenar.vkmessengeraac

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.lenarlenar.vkmessengeraac.viewmodel.ProfileViewModel

class ProfileViewModelFactory(val context: Application, val repository: ProfileDataSource) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  ProfileViewModel(context, repository) as T
    }
}