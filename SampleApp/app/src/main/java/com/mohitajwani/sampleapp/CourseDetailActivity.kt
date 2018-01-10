package com.mohitajwani.sampleapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_course_detail.*
import okhttp3.*
import java.io.IOException

/**
 * Created by Mohit Ajwani.
 */
class CourseDetailActivity: AppCompatActivity() {

    val TAG = CourseDetailActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        recyclerView_courseDetail.layoutManager = LinearLayoutManager(this)

        val navBarTitle = intent.getStringExtra(CustomViewHolder.VIDEO_TITLE_KEY)
        supportActionBar?.setTitle(navBarTitle)

        fetchCourseDetailsJson()
    }

    private class CourseDetailAdapter(): RecyclerView.Adapter<CourseLessonViewHolder>() {

        override fun onBindViewHolder(holder: CourseLessonViewHolder?, position: Int) {
            //val courseLesson = courseLessons.videos.get(position)
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CourseLessonViewHolder {
            val layoutInflater = LayoutInflater.from(parent?.context)
            val customView = layoutInflater.inflate(R.layout.course_lesson_row, parent, false)
            return CourseLessonViewHolder(customView)
        }

        override fun getItemCount(): Int {
            return 5
        }

    }

    private class CourseLessonViewHolder(val customView: View): RecyclerView.ViewHolder(customView){

    }

    private fun fetchCourseDetailsJson() {
        val videoId = intent.getIntExtra(CustomViewHolder.VIDEO_ID_KEY, -1)
        val courseDetailUrl = "https://api.letsbuildthatapp.com/youtube/course_detail?id=" + videoId

        val request = Request.Builder().url(courseDetailUrl).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                Log.i(TAG, body)

                val gson = GsonBuilder().create()

                val courseLessons = gson.fromJson(body, Array<CourseLesson>::class.java)

//                runOnUiThread {
//                    recyclerView_courseDetail.adapter = CourseDetailAdapter(courseLessons)
//                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                Log.e(TAG, "Failed to execute call")
            }

        })
    }

}