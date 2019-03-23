package niebieskaorka.boradgames.ui.composer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import niebieskaorka.boradgames.R

class ReserveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reserve_screen)


        val ss: String = intent.getStringExtra("gameID")
        println("GOT: " + ss)
    }
}