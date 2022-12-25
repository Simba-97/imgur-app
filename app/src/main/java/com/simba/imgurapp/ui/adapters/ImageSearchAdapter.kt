package com.simba.imgurapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simba.imgurapp.data.models.ImageItemDetails
import com.simba.imgurapp.databinding.ItemImageBinding
import com.simba.imgurapp.utils.BindingUtils

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
                BindingUtils.loadAndBindImage(binding.ivImage, this.additionalImages?.get(0)?.image)
                binding.valAdditionalImages.text = this.additionalImages?.size.toString()
                binding.title.text = this.title
                binding.postedAt.text = this.postedAt.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}