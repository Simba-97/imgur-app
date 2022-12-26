package com.simba.imgurapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simba.imgurapp.data.models.ImageItemDetails
import com.simba.imgurapp.databinding.ItemImageBinding
import com.simba.imgurapp.utils.BindingUtils
import com.simba.imgurapp.utils.DateUtils

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
                if (this.additionalImages.isNullOrEmpty()) {
                    binding.valAdditionalImages.text = "0"
                } else {
                    binding.valAdditionalImages.text = (this.additionalImages.size - 1).toString()
                }
                binding.title.text = this.title
                binding.postedAt.text = this.postedAt?.let { DateUtils.epochToIso8601(it) }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}