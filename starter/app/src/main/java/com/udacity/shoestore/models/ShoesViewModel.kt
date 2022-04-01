package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {
    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>> get() = _shoes

    fun addNewShoe(shoe: Shoe) {
        _shoes.value = shoes.value?.plus(shoe) ?: listOf(shoe)
    }
}
