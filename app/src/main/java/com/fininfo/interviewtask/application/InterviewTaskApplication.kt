package com.fininfo.interviewtask.application

import android.app.Application
import android.content.Context
import com.fininfo.interviewtask.util.Constants
import io.realm.Realm
import io.realm.RealmConfiguration

class InterviewTaskApplication : Application() {
    companion object {
        var ctx: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext

        //initialization of Realm database
        Realm.init(ctx)
        val config: RealmConfiguration =
            RealmConfiguration.Builder().name(Constants.USERSDATABASE).schemaVersion(1)
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true).build()

        Realm.setDefaultConfiguration(config)
    }
}