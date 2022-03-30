package com.udacity.shoestore.shoedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailViewModel : ViewModel() {
    private val _eventNavigateBack = MutableLiveData<Boolean>()
    val eventNavigateBack: LiveData<Boolean> get() = _eventNavigateBack

    fun onNavigateBackFinished() {
        _eventNavigateBack.value = false
    }

    fun onCancelButtonClick() {
        _eventNavigateBack.value = true
    }

    fun onSaveButtonClick() {
        // TODO: save
        _eventNavigateBack.value = true
    }
}
