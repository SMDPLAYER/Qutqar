package uz.smd.hakaton.app

import android.app.Application
import uz.smd.hakaton.local.LocalStorage

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LocalStorage.init(this)
        instance = this
    }

    companion object{
        lateinit var instance : App
    }
}