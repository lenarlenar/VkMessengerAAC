package com.lenarlenar.vkmessengeraac.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import com.lenarlenar.vkmessengeraac.ProfileDataSource
import com.lenarlenar.vkmessengeraac.model.ProfileResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProfileViewModel(context: Application, private val profileRepository: ProfileDataSource) : ViewModel() {
    private val _userName = MutableLiveData<String>()

    val userName
        get() = _userName


    fun start() {

        profileRepository.getUserName()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
            {
                _userName.value = it
            },
            {

            })

        }
}
