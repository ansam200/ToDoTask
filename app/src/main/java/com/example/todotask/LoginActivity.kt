package com.example.todotask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

	private lateinit var emailEditText: EditText
	private lateinit var passwordEditText: EditText
	private lateinit var loginButton: Button
	private lateinit var api: ApiService
	private lateinit var prefs: PreferencesManager

	override fun onCreate(savedInstanceState: Bundle?) {
    	super.onCreate(savedInstanceState)
    	setContentView(R.layout.activity_login)

    	prefs = PreferencesManager(this)
    	api = ApiClient.retrofit.create(ApiService::class.java)

    	emailEditText = findViewById(R.id.editEmail)
    	passwordEditText = findViewById(R.id.editPassword)
    	loginButton = findViewById(R.id.btnLogin)

    	loginButton.setOnClickListener {
        	val email = emailEditText.text.toString().trim()
        	val password = passwordEditText.text.toString().trim()

        	if (email.isEmpty() || password.isEmpty()) {
            	Toast.makeText(this, "يرجى إدخال البريد وكلمة المرور", Toast.LENGTH_SHORT).show()
        	} else {
            	loginUser(email, password)
        	}
    	}
	}

	private fun loginUser(email: String, password: String) {
    	api.getUsers().enqueue(object : Callback<List<User>> {
        	override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
            	if (response.isSuccessful) {
                	val user = response.body()?.find { it.email == email && it.password == password }
                	if (user != null) {
                    	prefs.saveUserId(user.id)
                    	startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    	finish()
                	} else {
                    	Toast.makeText(this@LoginActivity, "بيانات تسجيل الدخول غير صحيحة", Toast.LENGTH_SHORT).show()
                	}
            	} else {
                	Toast.makeText(this@LoginActivity, "فشل الاتصال بالخادم", Toast.LENGTH_SHORT).show()
            	}
        	}

        	override fun onFailure(call: Call<List<User>>, t: Throwable) {
            	Toast.makeText(this@LoginActivity, "خطأ في الشبكة: ${t.message}", Toast.LENGTH_LONG).show()
        	}
    	})
	}
}
