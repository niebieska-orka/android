package niebieskaorka.boradgames.ui.composer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.reserve_screen.*
import niebieskaorka.boradgames.R
import niebieskaorka.boradgames.data.model.Game
import niebieskaorka.boradgames.data.remote.Connection
import niebieskaorka.boradgames.data.remote.Storage
import niebieskaorka.boradgames.ui.common.GameAdapter
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.concurrent.thread

class ReserveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ss: String? = intent.getStringExtra("gameID")
        val num: Int? = intent.getIntExtra("number", 0)

        if (ss != null) {
            var game:Game? = Connection().getGame(ss)

            setContentView(R.layout.reserve_screen)

            var title = findViewById<TextView>(R.id.reserve_game_title)
            var descr = findViewById<TextView>(R.id.description)
            var play_time = findViewById<TextView>(R.id.reserve_game_time)
            var prod = findViewById<TextView>(R.id.reserve_manufacturer)
            var score = findViewById<TextView>(R.id.reserve_rating)
            var age = findViewById<TextView>(R.id.reserve_age)
            var ppl = findViewById<TextView>(R.id.reserve_how_many_people)
            var pic = findViewById<ImageView>(R.id.reserve_game_photo)
            if (game != null) {
                val df = DecimalFormat("#.#")
                df.roundingMode = RoundingMode.CEILING
                println(game!!.title)
                title.setText(game!!.title)
                Picasso.get().load(game!!.picture_url).placeholder(R.mipmap.ic_launcher).into(pic)
                descr.setText(game.description)
                play_time.setText(df.format(game.playing_time) + "h")
                prod.setText(game.publisher)
                score.setText(df.format(game.score))
                age.setText(game.min_age.toString())
                ppl.setText(game.min_players.toString() + "-" + game.max_players.toString())
            }
        }

        if (num != null) {
            println(num)
            var game = Storage.games.get(num)
            println(game.title)

            setContentView(R.layout.reserve_screen)

            var title = findViewById<TextView>(R.id.reserve_game_title)
            var descr = findViewById<TextView>(R.id.description)
            var play_time = findViewById<TextView>(R.id.reserve_game_time)
            var prod = findViewById<TextView>(R.id.reserve_manufacturer)
            var score = findViewById<TextView>(R.id.reserve_rating)
            var age = findViewById<TextView>(R.id.reserve_age)
            var ppl = findViewById<TextView>(R.id.reserve_how_many_people)
            var pic = findViewById<ImageView>(R.id.reserve_game_photo)
            if (game != null) {
                val df = DecimalFormat("#.#")
                df.roundingMode = RoundingMode.CEILING
                println(game!!.title)
                title.setText(game!!.title)
                Picasso.get().load(game!!.picture_url).placeholder(R.mipmap.ic_launcher).into(pic)
                descr.setText(game.description)
                play_time.setText(df.format(game.playing_time) + "h")
                prod.setText(game.publisher)
                score.setText(df.format(game.score))
                age.setText(game.min_age.toString())
                ppl.setText(game.min_players.toString() + "-" + game.max_players.toString())
            }
        }

        val reserve_button = findViewById<TextView>(R.id.reserve_button)
        reserve_button.setOnClickListener {
            startActivity(Intent(this, MakeResActivity::class.java))
        }
    }
}