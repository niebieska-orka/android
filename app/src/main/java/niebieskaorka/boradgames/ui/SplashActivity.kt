package niebieskaorka.boradgames.ui

import android.content.Intent
import android.os.Bundle
import niebieskaorka.boradgames.R
import android.support.v7.app.AppCompatActivity
import kotlin.concurrent.thread

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
    }


    override fun onResume() {
        super.onResume()

        thread(start = true) {
            // startup code goes here
            Thread.sleep(3000L)

            println("XDDD")

            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}