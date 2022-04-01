package com.udacity.shoestore.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    private var _binding: FragmentInstructionBinding? = null
    private val binding: FragmentInstructionBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInstructionBinding.inflate(inflater, container, false)
        binding.welcomeButton.setOnClickListener {
            findNavController().navigate(
                InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment()
            )
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
