package com.sharedpreferences.utility

import android.content.Context
import android.content.SharedPreferences

class SessionManager(val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor

    init {
        editor = sharedPreferences.edit()
        editor.apply()
    }

    companion object {
        private var sessionManager: SessionManager? = null
        fun getInstance(context: Context): SessionManager? {
            if (sessionManager == null) {
                sessionManager = SessionManager(context)
            }
            return sessionManager
        }
    }

    var passsword: String?
        get() = sharedPreferences.getString("password", "")
        set(value) {
            editor.putString("password", value)
            editor.apply()
        }


    var userName: Long
        get() = sharedPreferences.getLong("userName", 0)
        set(value) {
            editor.putLong("userName", value)
            editor.apply()
        }
}