package br.com.joaldo.login

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.joaldo.login.user.User

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        title = "Dashboard"
        var username = findViewById<TextView>(R.id.dashboard_username)
        var password = findViewById<TextView>(R.id.dashboard_password)

        var buser: Bundle = intent.extras!!

        username.setText(buser.getString("username"))
        password.setText(buser.getString("password"))

    }
}