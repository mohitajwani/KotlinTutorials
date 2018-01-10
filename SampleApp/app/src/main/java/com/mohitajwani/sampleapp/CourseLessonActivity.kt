package com.mohitajwani.sampleapp

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

        val courseLink = intent.getStringExtra(CourseDetailActivity.CourseLessonViewHolder.COURSE_LINK_KEY)

        webview_courseLesson.settings.javaScriptEnabled = true
        webview_courseLesson.settings.loadWithOverviewMode = true
        webview_courseLesson.settings.useWideViewPort = true

        webview_courseLesson.loadUrl(courseLink)
    }
}