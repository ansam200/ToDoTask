package com.example.todotask

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

	private val prefs: SharedPreferences =
    	context.getSharedPreferences("ToDoPrefs", Context.MODE_PRIVATE)

	fun saveUserId(userId: Int) {
    	prefs.edit().putInt("user_id", userId).apply()
	}

	fun getUserId(): Int {
    	return prefs.getInt("user_id", -1)
	}

	fun clearUserId() {
    	prefs.edit().remove("user_id").apply()
	}

	fun isDarkMode(): Boolean {
    	return prefs.getBoolean("dark_mode", false)
	}

	fun setDarkMode(enabled: Boolean) {
    	prefs.edit().putBoolean("dark_mode", enabled).apply()
	}
}
