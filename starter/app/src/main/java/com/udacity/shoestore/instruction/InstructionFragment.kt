package com.udacity.shoestore.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    private var _binding: FragmentInstructionBinding? = null
    private val binding: FragmentInstructionBinding get() = _binding!!

    private var _viewModel: InstructionViewModel? = null
    private val viewModel: InstructionViewModel get() = _viewModel!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInstructionBinding.inflate(inflater, container, false)
        _viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.eventNavigateToShoes.observe(viewLifecycleOwner) { newEvent ->
            if (newEvent) {
                findNavController().navigate(
                    InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
                )
                viewModel.onEventNavigateToShoesFinish()
            }
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
