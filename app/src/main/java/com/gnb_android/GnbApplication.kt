package com.gnb_android

import android.app.Application
import com.gnb_android.BuildConfig.BASE_URL
import com.gnb_android.initialization.data.DataModule

class GnbApplication: Application() {
    companion object {
        lateinit var dataModule: DataModule
    }

    override fun onCreate() {
        super.onCreate()
        initModules()
    }

    /**
     * This method has the responsibility of initialize app modules when starting application
     * For example, here we can add firebase analytics, app logs, etc.
     */
    private fun initModules() {
        dataModule = DataModule(BASE_URL)
    }
}