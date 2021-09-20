package br.com.joaldo.login.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.joaldo.login.R
import br.com.joaldo.login.R.id

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        title = "Dashboard"
        val username = findViewById<TextView>(id.dashboard_username)
        val password = findViewById<TextView>(id.dashboard_password)

        val bundle: Bundle = intent.extras!!

        username.text = bundle.getString("username")
        password.text = bundle.getString("password")

    }
}