package com.udacity.shoestore.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {
    private var _binding: FragmentShoeDetailBinding? = null
    private val binding: FragmentShoeDetailBinding get() = _binding!!

    private var _viewModel: ShoeDetailViewModel? = null
    private val viewModel: ShoeDetailViewModel get() = _viewModel!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        _viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.eventNavigateBack.observe(viewLifecycleOwner) { newEvent ->
            if (newEvent) {
                findNavController().navigateUp()
                viewModel.onNavigateBackFinished()
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
