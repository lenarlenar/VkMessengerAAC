package com.lenarlenar.vkmessengeraac

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login.setOnClickListener { VK.login(this, arrayListOf(VKScope.EMAIL, VKScope.FRIENDS, VKScope.MESSAGES)) }

        val sharedPreference= this.getSharedPreferences("com.vkontakte.android_pref_name"
            , Context.MODE_PRIVATE)
         val accessToken = VKAccessToken.restore(sharedPreference)

        if(accessToken != null){
            val intent: Intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKAuthCallback {
            override fun onLoginFailed(errorCode: Int) {

            }

            override fun onLogin(token: VKAccessToken) {
                val intent: Intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }


        }

        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
