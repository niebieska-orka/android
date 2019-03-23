package niebieskaorka.boradgames.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import niebieskaorka.boradgames.R
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
