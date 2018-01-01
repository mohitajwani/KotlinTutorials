package com.mohitajwani.sampleapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private class Person(val name:String, val age:Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(localClassName, "This is a simple log command")

        for (i in 0..100) {
            if (i % 5 == 0) {
                Log.i(localClassName, "Fully Divisible by 5")
            } else {
                Log.i(localClassName, "NOT Fully Divisible by 5")
            }
        }

        val person1 = Person("A", 10)
        val person2 = Person(name="B", age=12)
        val person3 = Person(age=15, name="C")

        Log.v(localClassName, "Person name = " + person1.name + "; age = " + person1.age)
        Log.w(localClassName, "Person name = " + person2.name + "; age = " + person2.age)
        Log.e(localClassName, "Person name = " + person3.name + "; age = " + person3.age)
    }
}
