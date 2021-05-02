package com.app.bsc20920

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainButtonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_button)
    }

    fun goOnRV(view: View) {

        val intent: Intent = Intent(this@MainButtonActivity, MainActivity::class.java)
        intent.putExtra("tag", view.getTag().toString())
        startActivity(intent)

    }

    fun OpenWeather(view: View) {
        val intent: Intent = Intent(this@MainButtonActivity, Weather::class.java)
        intent.putExtra("tag", view.getTag().toString())
        startActivity(intent)
    }
}