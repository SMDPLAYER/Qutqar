package uz.smd.hakaton.local

import android.content.Context

class LocalStorage private constructor(context: Context) {
    companion object {
        lateinit var instance: LocalStorage; private set

        fun init(context: Context) {
            instance = LocalStorage(context)
        }
    }

    private val pref = context.getSharedPreferences("LocalStorage", Context.MODE_PRIVATE)
//    private val pref = SecurePreferences(context, "55555", "LocalStorage")

    var isFirst: Boolean by BooleanPreferenceDefTrue(pref)
    var remember:String by StringPreference(pref)

    var result: Int by IntPreference(pref)
    var result1: Int by IntPreference(pref)
    var result2: Int by IntPreference(pref)
    var quiz:Int by IntPreference(pref)
    var cardPan:String by StringPreference(pref)
    var colorCard:String by StringPreference(pref)
    var password:String by StringPreference(pref)
    var lastName:String by StringPreference(pref)
    var firstName:String by StringPreference(pref)
    var added:String by StringPreference(pref)

    fun clear() {
        pref.edit().clear().apply()
    }
}