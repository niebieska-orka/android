package niebieskaorka.boradgames.ui.composer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import niebieskaorka.boradgames.R
import niebieskaorka.boradgames.data.remote.Storage
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.list_view)
        val listItems = arrayOfNulls<String>(Storage.games.size)
        for (i in 0 until Storage.games.size) {
            val game = Storage.games[i]
            listItems[i] = game.title
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

        val btn_qr = findViewById(R.id.qr_button) as Button
        btn_qr.setOnClickListener {
            thread(start = true) {
                startActivity(Intent(this, QrScanner::class.java))
            }
        }
    }

    public override fun onResume() {
        super.onResume()
//        map_view.onResume()

    }

    public override fun onPause() {
        super.onPause()
//        map_view.onPause()
    }
}
