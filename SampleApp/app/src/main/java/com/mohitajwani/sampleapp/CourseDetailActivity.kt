package com.mohitajwani.sampleapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_course_detail.*
import kotlinx.android.synthetic.main.course_lesson_row.view.*
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

    private class CourseDetailAdapter(val courseLessons: Array<CourseLesson>): RecyclerView.Adapter<CourseLessonViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CourseLessonViewHolder {
            val layoutInflater = LayoutInflater.from(parent?.context)
            val customView = layoutInflater.inflate(R.layout.course_lesson_row, parent, false)
            return CourseLessonViewHolder(customView)
        }

        override fun onBindViewHolder(holder: CourseLessonViewHolder?, position: Int) {
            val courseLesson = courseLessons.get(position)
            holder?.customView?.textView_lessonTitle?.text = courseLesson.name
            holder?.customView?.textView_lessonDuration?.text = courseLesson.duration

            val imageView = holder?.customView?.imageView_course_lesson
            Picasso.with(holder?.customView?.context).load(courseLesson.imageUrl).into(imageView)

            holder?.courseLesson = courseLesson
        }

        override fun getItemCount(): Int {
            return courseLessons.size
        }

    }

    class CourseLessonViewHolder(val customView: View, var courseLesson: CourseLesson? = null): RecyclerView.ViewHolder(customView){

        companion object {
            val COURSE_LINK_KEY = "COURSE_LINK"
        }
        init {
            customView.setOnClickListener {
                val intent = Intent(customView.context, CourseLessonActivity::class.java)
                intent.putExtra(COURSE_LINK_KEY, courseLesson?.link)
                customView.context.startActivity(intent)
            }
        }
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

                runOnUiThread {
                    recyclerView_courseDetail.adapter = CourseDetailAdapter(courseLessons)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                Log.e(TAG, "Failed to execute call")
            }

        })
    }

}