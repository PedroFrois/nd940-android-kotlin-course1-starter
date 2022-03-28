package com.udacity.shoestore.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel() {
    private val _eventNavigateToShoes = MutableLiveData<Boolean>()
    val eventNavigateToShoes: LiveData<Boolean> get() = _eventNavigateToShoes

    fun onEventNavigateToShoesFinish() {
        _eventNavigateToShoes.value = false
    }

    fun onButtonClick() {
        _eventNavigateToShoes.value = true
    }
}
