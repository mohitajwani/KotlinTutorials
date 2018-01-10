package com.mohitajwani.sampleapp

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_course_lesson.*

/**
 * Created by Mohit Ajwani.
 */
class CourseLessonActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_course_lesson)
        webview_courseLesson.setBackgroundColor(Color.YELLOW)
    }
}