package com.example.eventm

import android.app.Application
import com.orhanobut.hawk.Hawk

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Hawk.init(this).build()
    }
}