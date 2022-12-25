package com.simba.imgurapp.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simba.imgurapp.R
import com.simba.imgurapp.data.models.ImageItemDetails
import com.simba.imgurapp.databinding.LayoutImageSearchBinding
import com.simba.imgurapp.ui.adapters.ImageSearchAdapter
import com.simba.imgurapp.ui.viewmodels.UserSearchEvent
import com.simba.imgurapp.ui.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageSearchFragment : Fragment() {

    private var _binding: LayoutImageSearchBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    //Injecting the viewModel
    private val userViewModel: UserViewModel by viewModels()

    private var isLinearLayoutManager = true

    private var list: List<ImageItemDetails>? = null

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
        userViewModel.onTriggerEvent(
            UserSearchEvent.SearchImagesByWeek(
                "cats"
            )
        )
        recyclerView = binding.recyclerView
        subscriberObserver()
    }

    private fun subscriberObserver() {
        userViewModel.uiState.asLiveData().observe(viewLifecycleOwner) { uiState ->
            if (uiState.status == 200) {
                list = uiState.data
                chooseLayout(uiState.data)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //toggles the layout between linear and grid layout.
    private fun chooseLayout(list: List<ImageItemDetails>?) {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        } else {
            recyclerView.layoutManager = GridLayoutManager(context, 3)
        }
        recyclerView.adapter = list?.let { ImageSearchAdapter(it) }
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
                chooseLayout(list)
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}