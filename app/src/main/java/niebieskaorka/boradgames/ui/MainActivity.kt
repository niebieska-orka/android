package niebieskaorka.boradgames.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import niebieskaorka.boradgames.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
