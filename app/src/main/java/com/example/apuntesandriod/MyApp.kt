package com.example.apuntesandriod

import android.app.Application

class MyApp: Application() {
    companion object{
        private lateinit var instace:MyApp
        public val Context: MyApp get() = instace
    }

    override fun onCreate() {
        super.onCreate()
        instace = this
    }
}