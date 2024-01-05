package com.example.basketlyfe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DaftarViewModel : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var konfirmasi by mutableStateOf("")
    private val _hasStrongPassword = MutableLiveData(false)
    val hasStrongPassword: LiveData<Boolean> get() = _hasStrongPassword

    fun updateHasStrongPassword(isStrong: Boolean) {
        _hasStrongPassword.value = isStrong
    }

    fun onEmailChanged(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    fun onKonfirmasiChanged(newKonfirmasi: String) {
        konfirmasi = newKonfirmasi
    }

    // Example function for handling registration
    fun registerUser() {
        // Implement your registration logic here
        // You can access email, password, konfirmasi, hasStrongPassword properties

        // Example: Validate the form fields
        if (validateForm()) {
            // Perform registration logic (e.g., call a repository function)
            // Note: It's recommended to use a repository to interact with data sources
            // For simplicity, you can perform registration logic directly here
            viewModelScope.launch {
                // Example: Call a repository function to register the user
                // UserRepository.registerUser(email, password)

                // TODO: Implement your registration logic here

                // After registration, you can perform additional actions if needed
            }
        } else {
            // Handle validation errors or show a message to the user
        }
    }

    private fun validateForm(): Boolean {
        // Implement your form validation logic
        // Return true if the form is valid; otherwise, return false

        // Example: Check if email, password, and konfirmasi are not empty
        return email.isNotEmpty() && password.isNotEmpty() && konfirmasi.isNotEmpty()
                && password == konfirmasi && _hasStrongPassword.value == true
    }

    //contoh logout pak evan

//    fun logout(
//        navController: NavController,
//        dataStore: DataStoreManager
//    ) {
//        viewModelScope.launch {
//            MyDBContainer().myDBRepositories.logout()
//            dataStore.saveToken("")
//            MyDBContainer.ACCESS_TOKEN = ""
//
//            navController.navigate(ListScreen.Login.name){
//                popUpTo(ListScreen.ListMovie.name){inclusive = true}
//            }
//        }
//    }
}
