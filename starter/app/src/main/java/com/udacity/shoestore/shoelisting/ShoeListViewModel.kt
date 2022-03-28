package com.udacity.shoestore.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>> get() = _shoes

    private val _eventNavigateToDetail = MutableLiveData<Boolean>()
    val eventNavigateToDetail: LiveData<Boolean> get() = _eventNavigateToDetail

    fun onEventNavigateToDetailFinish() {
        _eventNavigateToDetail.value = false
    }

    fun onButtonClick() {
        _eventNavigateToDetail.value = true
    }
}
