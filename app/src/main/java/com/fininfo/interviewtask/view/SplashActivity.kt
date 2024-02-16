package com.fininfo.interviewtask.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fininfo.interviewtask.R
import com.fininfo.interviewtask.util.Constants

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //below shared preference is to store login details for user
        val sharedPreference = getSharedPreferences(Constants.USER_LOGIN_DETSILS, Context.MODE_PRIVATE)
        if (!sharedPreference.getBoolean(Constants.ONE_TIME_LOGIN_DETAILS, false)) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}