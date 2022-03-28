package com.udacity.shoestore.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _eventNavigateToInstructions = MutableLiveData<Boolean>()
    val eventNavigateToInstructions: LiveData<Boolean> get() = _eventNavigateToInstructions

    fun onEventNavigateToInstructionsFinish() {
        _eventNavigateToInstructions.value = false
    }

    fun onButtonClick() {
        _eventNavigateToInstructions.value = true
    }
}
