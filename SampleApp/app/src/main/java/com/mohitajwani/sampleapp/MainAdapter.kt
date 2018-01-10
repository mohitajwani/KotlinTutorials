package com.mohitajwani.sampleapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

/**
 * Created by Mohit Ajwani.
 */
class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomViewHolder>() {

    //val videoTitles = listOf("First", "Second Title", "3rd One", "More Titles")

    //number of items
    override fun getItemCount(): Int {
        return homeFeed.videos.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val video = homeFeed.videos.get(position)
        holder?.view?.textView_video_title?.text = video.name
        holder?.view?.textView_channel_title?.text = video.channel.name

        val channelImageView = holder?.view?.imageView_video
        Picasso.with(holder?.view?.context).load(video.imageUrl).into(channelImageView)

        val thumbNailImageView = holder?.view?.imageView_thumbnail
        Picasso.with(holder?.view?.context).load(video.channel.profileImageUrl).into(thumbNailImageView)
        holder?.video = video
    }
}

class CustomViewHolder(val view: View, var video: Video? = null): RecyclerView.ViewHolder(view) {

    companion object {
        val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        val VIDEO_ID_KEY = "VIDEO_ID"
    }
    init {
        view.setOnClickListener {
            val intent = Intent(view.context, CourseDetailActivity::class.java)
            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)
            view.context.startActivity(intent)
        }
    }
}