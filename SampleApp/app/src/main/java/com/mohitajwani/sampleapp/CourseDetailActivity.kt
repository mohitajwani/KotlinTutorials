package com.mohitajwani.sampleapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_course_detail.*

/**
 * Created by Mohit Ajwani.
 */
class CourseDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        recyclerView_courseDetail.layoutManager = LinearLayoutManager(this)
    }
}