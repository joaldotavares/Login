package br.com.joaldo.login

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.method.MovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import br.com.joaldo.login.user.User

class LoginActivity : Activity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        setContentView(R.layout.activity_login)
        var username = findViewById<EditText>(R.id.login_username)
        var password = findViewById<EditText>(R.id.login_password)
        //var forgotPassword = findViewById<TextView>(R.id.login_forgot_password)
        //val text = "<a href='https://m.youtube.com' target='_blank'>Forgot Password?</a>"
        //forgotPassword.text = Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
        val btnSignIn = findViewById<Button>(R.id.login_btn_signin)

        btnSignIn.setOnClickListener {
            chamaActivity(username, password)
        }
    }

    private fun chamaActivity(username: EditText, password: EditText) {

        var user = User(username.text.toString(), password.text.toString())
        Log.i("Teste parametros", user.username + " " + user.password)
        if(!user.username.isNullOrEmpty() && !user.password.isNullOrEmpty()) {
            val intent = Intent(this, DashboardActivity::class.java)
            intent.putExtra("username", user.username)
            intent.putExtra("password", user.password)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Coloca alguma coisa ai parça", Toast.LENGTH_LONG).show()
        }
    }
}


