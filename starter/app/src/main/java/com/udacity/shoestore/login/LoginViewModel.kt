package com.udacity.shoestore.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _eventNavigateToWelcome = MutableLiveData<Boolean>()
    val eventNavigateWelcome: LiveData<Boolean> get() = _eventNavigateToWelcome

    fun onEventNavigateToWelcomeFinish() {
        _eventNavigateToWelcome.value = false
    }

    fun onSignInClick() {
        _eventNavigateToWelcome.value = true
    }

    fun onSignUpClick() {
        _eventNavigateToWelcome.value = true
    }
}
