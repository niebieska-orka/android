package niebieskaorka.boradgames.ui.composer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import niebieskaorka.boradgames.R
import niebieskaorka.boradgames.data.remote.Storage
import niebieskaorka.boradgames.ui.common.GameAdapter
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.list_view)

        val adapter = GameAdapter(this, Storage.games)

        listView.adapter = adapter

        val btn_qr = findViewById(R.id.qr_button) as Button
        btn_qr.setOnClickListener {
            thread(start = true) {
                startActivity(Intent(this, QrScanner::class.java))
            }
        }

        listView.setOnClickListener() {
            println("AA`ą")
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
