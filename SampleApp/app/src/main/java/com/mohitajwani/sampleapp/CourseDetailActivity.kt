package com.mohitajwani.sampleapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private class CourseDetailAdapter: RecyclerView.Adapter<CourseLessonViewHolder>() {

        override fun onBindViewHolder(holder: CourseLessonViewHolder?, position: Int) {

        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CourseLessonViewHolder {
            val layoutInflater = LayoutInflater.from(parent?.context)
            val customView = layoutInflater.inflate(R.layout.video_row, parent, false)
            return CourseLessonViewHolder(customView)
        }

        override fun getItemCount(): Int {
            return 5
        }

    }

    private class CourseLessonViewHolder(val customView: View): RecyclerView.ViewHolder(customView){

    }
}