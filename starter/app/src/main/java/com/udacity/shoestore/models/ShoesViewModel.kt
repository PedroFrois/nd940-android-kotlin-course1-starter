package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoesViewModel : ViewModel() {
    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>> get() = _shoes

    val name = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val company = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun addNewShoe() {
        Shoe(
            name = name.value ?: "",
            size = size.value?.toDoubleOrNull() ?: 0.0,
            company = company.value ?: "",
            description = description.value ?: "",
        ).let { shoe ->
            _shoes.value = shoes.value?.plus(shoe) ?: listOf(shoe)
        }
    }
}
