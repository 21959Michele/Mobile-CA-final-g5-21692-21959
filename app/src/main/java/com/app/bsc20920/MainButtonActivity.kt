// Michele Sousa & Mubasher Zeb Khan

// 21959 & 21694

package com.app.bsc20920

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL

class MainButtonActivity : AppCompatActivity() {

    companion object {

        var list: List<Signup.Pin>? = null
    }
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

    fun bikelocdub(view: View) {

        val url: URL? = try {
            URL("https://api.jcdecaux.com/vls/v1/stations?contract=dublin&apiKey=ffdb3b515b84f13dc7a8cb4426620f1f94bcef29")


        } catch (e: MalformedURLException) {
            Log.d("Exception", e.toString())
            null
        }


        lifecycleScope.launch(Dispatchers.IO) {
            url?.getString()?.apply {

                withContext(Dispatchers.Default) {
                    list = parseJson(this@apply)



                    withContext(Dispatchers.Main) {


                        var intent: Intent = Intent(this@MainButtonActivity, MapAct::class.java)

                        startActivity(intent)


                    }


                }
            }
        }
    }

    fun URL.getString(): String? {
        val stream = openStream()
        return try {
            val r = BufferedReader(InputStreamReader(stream))
            val result = StringBuilder()
            var line: String?
            while (r.readLine().also { line = it } != null) {
                result.append(line).appendln()
            }
            result.toString()
        } catch (e: IOException) {
            e.toString()
        }
    }

    fun parseJson(data: String): List<Signup.Pin>? {
        val list = mutableListOf<Signup.Pin>()

        try {
            val array = JSONArray(data);

            for (i in 0 until array.length()) {
                val obj = JSONObject(array[i].toString())


                val obj2 = obj.getJSONObject("position")


                val lat = obj2.getDouble("lat")
                val lng = obj2.getDouble("lng")

                Log.i("ttaagg", "parseJson: " + lat)
                list.add(Signup.Pin(lat, lng))
            }
        } catch (e: JSONException) {
            Log.d("Exception", e.toString())
        }

        return list
    }

    fun bikeloclyon(view: View) {

        val url: URL? = try {
            URL("https://api.jcdecaux.com/vls/v1/stations?contract=lyon&apiKey=ffdb3b515b84f13dc7a8cb4426620f1f94bcef29")


        } catch (e: MalformedURLException) {
            Log.d("Exception", e.toString())
            null
        }


        lifecycleScope.launch(Dispatchers.IO) {
            url?.getString()?.apply {

                withContext(Dispatchers.Default) {
                    list = parseJson(this@apply)



                    withContext(Dispatchers.Main) {


                        var intent: Intent = Intent(this@MainButtonActivity, MapAct::class.java)

                        startActivity(intent)


                    }


                }
            }
        }

    }

    fun editData(view: View) {
        val i = Intent(this, Signup2::class.java)
        i.putExtra("edit", true)
        startActivity(i)
    }
}
