package niebieskaorka.boradgames.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import niebieskaorka.boradgames.R

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)

        var btn_register = findViewById<TextView>(R.id.register_button)

        btn_register.setOnClickListener {
            var e_user_email = findViewById<TextView>(R.id.user_email)
            var e_user_pwd = findViewById<TextView>(R.id.user_password)
            var e_user_name = findViewById<TextView>(R.id.user_name)
            var e_user_surname = findViewById<TextView>(R.id.user_surname)
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
