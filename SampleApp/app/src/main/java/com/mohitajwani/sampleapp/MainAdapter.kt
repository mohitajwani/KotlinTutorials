package com.mohitajwani.sampleapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.video_row.view.*

/**
 * Created by Mohit Ajwani.
 */
class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitles = listOf("First", "Second Title", "3rd One", "More Titles")

    //number of items
    override fun getItemCount(): Int {
        return videoTitles.size;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        holder?.view?.textView_video_title?.text = videoTitles.get(position)
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}