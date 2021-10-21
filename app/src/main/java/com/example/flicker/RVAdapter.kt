package com.example.flicker

import android.system.Os.link
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flicker.databinding.ItemRowBinding

class RVAdapter(val activity: MainActivity, private val photos: ArrayList<photo>) :
    RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val ph = photos[position]
        holder.binding.apply {
            tvImageText.text = ph.title
            Glide.with(activity).load(ph.link).into(ivThumbnail)
            llItemRow.setOnClickListener {
                activity.openImg(ph.link)
            }
        }
    }

    override fun getItemCount() = photos.size
}

