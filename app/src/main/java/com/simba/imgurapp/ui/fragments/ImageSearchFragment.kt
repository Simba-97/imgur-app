package com.simba.imgurapp.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simba.imgurapp.R
import com.simba.imgurapp.data.models.ImageItemDetails
import com.simba.imgurapp.databinding.LayoutImageSearchBinding
import com.simba.imgurapp.ui.adapters.ImageSearchAdapter

class ImageSearchFragment : Fragment() {

    private var _binding: LayoutImageSearchBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    private var isLinearLayoutManager = true

    private val list: List<ImageItemDetails> = mutableListOf(
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
//        ImageItemDetails(R.drawable.download, "Android", "02/03/01 12:00 am", 3),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutImageSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView

        chooseLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //toggles the layout between linear and grid layout.
    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        } else {
            recyclerView.layoutManager = GridLayoutManager(context, 3)
        }
        recyclerView.adapter = ImageSearchAdapter(list)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_layout, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }

    //Determines if the option in the menu item has been selected.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                // Sets isLinearLayoutManager to the opposite value
                isLinearLayoutManager = !isLinearLayoutManager
                // Sets layout and icon. Refer to the function to the see what it does
                chooseLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}