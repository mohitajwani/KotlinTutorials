package com.mohitajwani.sampleapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    val TAG = MainActivity::class.simpleName
    private class Person(val name: String, val age: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        //Learning code
        Log.d(localClassName, "This is a simple log command")

        for (i in 1..100) {
            if (i % 5 == 0) {
                Log.i(localClassName, "Number " + i + " is Fully Divisible by 5")
            } else {
                Log.i(localClassName, "Number " + i + " is NOT Fully Divisible by 5")
            }
        }

        val person1 = Person("A", 10)
        val person2 = Person(name = "B", age = 12)
        val person3 = Person(age = 15, name = "C")

        Log.v(localClassName, "Person name = " + person1.name + "; age = " + person1.age)
        Log.w(localClassName, "Person name = " + person2.name + "; age = " + person2.age)
        Log.e(localClassName, "Person name = " + person3.name + "; age = " + person3.age)
        */

        recyclerView_main.layoutManager = LinearLayoutManager(this)
        //recyclerView_main.adapter = MainAdapter()

        fetchJson()
    }

    private fun fetchJson() {
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                Log.i(TAG, body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    recyclerView_main.adapter = MainAdapter(homeFeed)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                Log.e(TAG, "Failed to execute call")
            }

        })
    }
}

class HomeFeed(val videos: List<Video>)

class Video(val id: Int, val name: String, val link: String, val imageUrl: String,
            val numberOfViews: Int, val channel: Channel)

class Channel(val name: String, val profileImageUrl: String)