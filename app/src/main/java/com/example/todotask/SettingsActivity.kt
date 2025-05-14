package com.example.todotask

import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class SettingsActivity : AppCompatActivity() {
	private lateinit var prefs: PreferencesManager

	override fun onCreate(savedInstanceState: Bundle?) {
    	super.onCreate(savedInstanceState)
    	setContentView(R.layout.activity_settings)

    	prefs = PreferencesManager(this)
    	val darkSwitch = findViewById<Switch>(R.id.switchDarkMode)
    	darkSwitch.isChecked = prefs.isDarkMode()

    	darkSwitch.setOnCheckedChangeListener { _, isChecked ->
        	prefs.setDarkMode(isChecked)
        	AppCompatDelegate.setDefaultNightMode(
            	if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
            	else AppCompatDelegate.MODE_NIGHT_NO
        	)
    	}
	}
}
