package br.com.joaldo.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.joaldo.login.user.User

class LoginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        setContentView(R.layout.activity_login)
        val username = findViewById<EditText>(R.id.login_username)
        val password = findViewById<EditText>(R.id.login_password)
        val btnSignIn = findViewById<Button>(R.id.login_btn_signin)

        btnSignIn.setOnClickListener {
            loadActivity(username, password)
        }
    }

    private fun loadActivity(username: EditText, password: EditText) {

        val user = User(username.text.toString(), password.text.toString())
        checkFields(user)
    }

    private fun checkFields(user: User) {
        if (user.username.isNotEmpty() && user.password.isNotEmpty()) {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("username", user.username)
            intent.putExtra("password", user.password)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Coloca alguma coisa ai parça", Toast.LENGTH_LONG).show()
        }
    }
}


