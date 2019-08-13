package com.example.eventm

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(private val context: Context) {
    private var sharedPreferences: SharedPreferences? = null

    init {
        getSharedPreference()
    }

    private fun getSharedPreference() {
        sharedPreferences = context.getSharedPreferences("my_preference", Context.MODE_PRIVATE)
    }

    // method untuk tidak muncul lagi
    fun writePreference() {
        val editor = sharedPreferences!!.edit()
        editor.putString("my_preference_key", "init_ok")
        editor.commit()
    }

    // method untuk tidak muncul lagi
    fun checkPreference(): Boolean {
        var status = false
        if (sharedPreferences!!.getString("my_preference_key", "null") == "null") {
            status = false
        } else {
            status = true
        }
        return status
    }


}
