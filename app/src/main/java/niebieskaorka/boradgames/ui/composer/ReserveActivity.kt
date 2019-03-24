package niebieskaorka.boradgames.ui.composer

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.TextView
import niebieskaorka.boradgames.R
import niebieskaorka.boradgames.data.model.Game
import niebieskaorka.boradgames.data.remote.Connection
import niebieskaorka.boradgames.data.remote.Storage
import niebieskaorka.boradgames.ui.common.GameAdapter
import kotlin.concurrent.thread

class ReserveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ss: String = intent.getStringExtra("gameID")
        var game:Game? = null

        thread(start = true) {
            game = Connection().getGame(ss)
        }

        var title = findViewById<TextView>(R.id.reserve_game_title)
        if (game != null) {
            println(game!!.title)
            title.setText(game!!.title)
        }

        setContentView(R.layout.reserve_screen)

        println("GOT: " + ss)
    }
}