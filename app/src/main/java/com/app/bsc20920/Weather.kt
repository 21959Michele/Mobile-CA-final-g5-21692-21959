package com.app.bsc20920

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.activity_weather.pb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL

class Weather : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
//        http://api.openweathermap.org/data/2.5/weather?q=paris&appid=8495ecc85bf82701f23617bbc9d8084f
        val tag = intent.getStringExtra("tag")

        val url: URL? = try {
            if (tag.equals("0"))
                URL("http://api.openweathermap.org/data/2.5/weather?q=paris&appid=8495ecc85bf82701f23617bbc9d8084f")
            else
                URL("http://api.openweathermap.org/data/2.5/weather?q=dublin&appid=8495ecc85bf82701f23617bbc9d8084f")


        } catch (e: MalformedURLException) {
            Log.d("Exception", e.toString())
            null
        }




        lifecycleScope.launch(Dispatchers.IO) {
            url?.getString()?.apply {

                withContext(Dispatchers.Default) {
                    val weath = parseJson(this@apply)

                    withContext(Dispatchers.Main) {
                        pb.visibility = View.GONE

                        city.text = weath?.city
                        clear.text = weath?.clear
                        clearSky.text = weath?.clearSky
                        temp.text = weath?.temp
                        tempMin.text = weath?.tempMin
                        tempMax.text = weath?.tempMax
                        humidity.text = weath?.humdity
                        Log.d("ttaagg", "onCreate: " + weath?.imgLink)
                        Picasso.with(this@Weather).load(weath?.imgLink).into(ivmain);
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


    // data class to hold student instance
    public data class weather(
        val imgLink: String,//done
        val city: String, //done
        val clear: String,//done
        val clearSky: String, //done
        val temp: String,
        val tempMin: String,
        val tempMax: String,
        val humdity: String,

        )


    // parse json data
    fun parseJson(data: String): weather? {
        var weather2: weather? = null
        try {
            val array = JSONObject(data).getJSONArray("weather");
            val obj = array.getJSONObject(0)

            val city = "City : " + JSONObject(data).getString("name")
            val imgLink = "http://openweathermap.org/img/wn/${obj.getString("icon")}@4x.png"
            val clear = "Weather : " + obj.getString("main")
            val clearSky = "Des : " + obj.getString("description")

            val tempObj = JSONObject(data).getJSONObject("main")

            val temp = "Temp : " + tempObj.getString("temp")
            val tempMin = "Temp Min : " + tempObj.getString("temp_min")
            val tempMax = "Temp Max : " + tempObj.getString("temp_max")

            val humdity = "Humidity : " + tempObj.getInt("humidity")


            weather2 = weather(
                imgLink,
                city,
                clear,
                clearSky,
                temp,
                tempMin,
                tempMax,
                humdity.toString()
            )


        } catch (e: JSONException) {
            Log.d("Exception", e.toString())
        }

        return weather2
    }

}