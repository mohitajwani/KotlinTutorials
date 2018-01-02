package com.mohitajwani.sampleapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
        recyclerView_main.adapter = MainAdapter()
    }
}
