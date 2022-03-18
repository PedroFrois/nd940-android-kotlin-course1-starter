package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private var _viewModel: LoginViewModel? = null
    private val viewModel get() = _viewModel!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        _viewModel = ViewModelProvider(this).get(modelClass = LoginViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventNavigateWelcome.observe(viewLifecycleOwner, Observer { newEvent ->
            if (newEvent) {
                // TODO:  findNavController().navigate()
                viewModel.onEventNavigateToWelcomeFinish()
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}