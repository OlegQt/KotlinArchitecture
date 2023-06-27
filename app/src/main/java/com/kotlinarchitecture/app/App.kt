package com.kotlinarchitecture.app

import android.app.Application

class App:Application() {
    var strInfo = "Application"

    override fun onCreate() {
        super.onCreate()
        if(instance==null) instance = this
        else{
            strInfo = strInfo.plus(" call")
        }

    }

    companion object{
        var instance:App? = null
    }
}