package com.simba.imgurapp.ui.adapters

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simba.imgurapp.data.models.ImageItemDetails
import com.simba.imgurapp.databinding.ItemImageBinding

class ImageSearchAdapter(private var list: List<ImageItemDetails>) :
    RecyclerView.Adapter<ImageSearchAdapter.ImageSearchViewHolder>() {

    inner class ImageSearchViewHolder(val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSearchViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageSearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageSearchViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
//                binding.ivImage.setImageResource(this.image)
//                binding.valAdditionalImages.text = this.additionalImages.toString()
//                binding.title.text = this.title
//                binding.postedAt.text = this.postedAt
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}