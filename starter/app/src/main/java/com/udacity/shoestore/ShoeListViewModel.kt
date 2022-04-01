package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {
    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>> get() = _shoes

    fun addNewShoe(shoe: Shoe) {
        _shoes.value = shoes.value?.plus(shoe) ?: listOf(shoe)
    }
}
