package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    private var _binding: FragmentShoeDetailBinding? = null
    private val binding: FragmentShoeDetailBinding get() = _binding!!

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.saveButton.setOnClickListener {
            viewModel.addNewShoe(getShoeFromForm())
            findNavController().navigateUp()
        }
        return binding.root
    }

    private fun getShoeFromForm(): Shoe {
        return Shoe(
            name = binding.shoeNameEdit.text.toString(),
            size = binding.shoeSizeEdit.text.toString().toDoubleOrNull() ?: 0.0,
            company = binding.companyEdit.text.toString(),
            description = binding.descriptionEdit.text.toString()
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
