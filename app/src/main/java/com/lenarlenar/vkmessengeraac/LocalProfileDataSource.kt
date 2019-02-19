package com.lenarlenar.vkmessengeraac

import com.lenarlenar.vkmessengeraac.model.ProfileResponse
import com.lenarlenar.vkmessengeraac.model.VkProfile
import io.reactivex.Observable
import io.reactivex.Single
import java.io.PrintWriter
import java.sql.Connection
import java.util.logging.Logger
import javax.inject.Inject
import javax.sql.DataSource

class LocalProfileDataSource @Inject constructor() : ProfileDataSource{
    override fun getUserName() : Single<String> {
        return Observable.empty<String>().single("Имя_из_базы")
    }
}
