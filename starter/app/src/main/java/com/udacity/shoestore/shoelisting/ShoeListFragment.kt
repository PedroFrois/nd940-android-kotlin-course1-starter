package com.udacity.shoestore.shoelisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment : Fragment() {

    private var _binding: FragmentShoeListBinding? = null
    private val binding: FragmentShoeListBinding get() = _binding!!

    private var _viewModel: ShoeListViewModel? = null
    private val viewModel: ShoeListViewModel get() = _viewModel!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)
        _viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.eventNavigateToDetail.observe(viewLifecycleOwner) { newEvent ->
            if (newEvent) {
                findNavController().navigate(
                    ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
                )
                viewModel.onEventNavigateToDetailFinish()
            }
        }

        viewModel.shoes.observe(viewLifecycleOwner) { newListOfShoes ->
            newListOfShoes.forEach {
                binding.shoesListLinearLayout.addView(
                    createShoeListItemView(
                        inflater,
                        container,
                        it
                    ),
                    binding.shoesListLinearLayout.childCount - 1
                )
            }
        }

        return binding.root
    }

    private fun createShoeListItemView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        shoe: Shoe
    ): View {
        return ItemShoeListBinding.inflate(inflater, container, false).apply {
            fieldName.text = shoe.name
            fieldCompany.text = shoe.company
            fieldSize.text = shoe.size.toString()
        }.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
