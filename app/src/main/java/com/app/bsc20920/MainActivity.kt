// Michele Sousa & Mubasher Zeb Khan

// 21959 & 21694


package com.app.bsc20920

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
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

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager

        val tag = intent.getStringExtra("tag")

        val url: URL? = try {
            if (tag.equals("0"))
                URL("https://api.jcdecaux.com/vls/v1/stations?contract=dublin&apiKey=ffdb3b515b84f13dc7a8cb4426620f1f94bcef29")
            else
                URL("https://api.jcdecaux.com/vls/v1/stations?contract=lyon&apiKey=ffdb3b515b84f13dc7a8cb4426620f1f94bcef29")

        } catch (e: MalformedURLException) {
            Log.d("Exception", e.toString())
            null
        }




        lifecycleScope.launch(Dispatchers.IO) {
            url?.getString()?.apply {

                withContext(Dispatchers.Default) {
                    val list = parseJson(this@apply)

                    withContext(Dispatchers.Main) {
                        pb.visibility = GONE
                        val adapter = RecyvlerAdapter(list as ArrayList<Bikes>)

                        //now adding the adapter to recyclerview
                        rv.adapter = adapter

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
    public data class Bikes(
        val name: String,
        val address: String,
        val status: String,
        val availbikes: Int
    )


    // parse json data
    fun parseJson(data: String): List<Bikes>? {
        val list = mutableListOf<Bikes>()

        try {
            val array = JSONArray(data);

            for (i in 0 until array.length()) {
                val obj = JSONObject(array[i].toString())
                val name = obj.getString("name")
                val address = obj.getString("address")
                val status = obj.getString("status")
                val availBikes = obj.getInt("available_bikes")
                list.add(Bikes(name, address, status, availBikes))
            }
        } catch (e: JSONException) {
            Log.d("Exception", e.toString())
        }

        return list
    }

}
