package com.example.basketlyfe.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.basketlyfe.data.DataStoreManager
import com.example.basketlyfe.model.User
import com.example.basketlyfe.repositories.MyDBContainer
import com.example.basketlyfe.ui.ListScreen
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DaftarViewModel (private val navController: NavController): ViewModel(){

    var email by mutableStateOf("")
    var name by mutableStateOf("")
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

    fun onNameChanged(newName: String) {
        name = newName
    }

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    fun onKonfirmasiChanged(newKonfirmasi: String) {
        konfirmasi = newKonfirmasi
    }

    fun onMasukClicked() {
        // Handle any logic related to the Daftar button click
        navController.navigate(ListScreen.Masuk.name)
    }

    // Example function for handling registration
    fun registerUser(
        name: String,
        email: String,
        password: String,
        dataStore: DataStoreManager
    ) {
        if (validateForm()) {
            val user = User(
                email = email,
                name = name,
                password = password
            )
            viewModelScope.launch {
                // Example: Call a repository function to register the user
                try {
                    val response = MyDBContainer().myDBRepositories.register(user)

                    val data = response.data as List<*>
                    Log.d("register response", response.data.toString())

                    dataStore.saveToken(data[1] as String)
                    dataStore.saveEmail(data[0] as String)

                    dataStore.getEmail.collect{
                        if (it != null) {
                            MyDBContainer.EMAIL = it
                        }
                    }
                    Log.d("Email", MyDBContainer.EMAIL)

                    dataStore.getToken.collect{
                        if (it != null) {
                            MyDBContainer.ACCESS_TOKEN = it
                        }
                    }
                    Log.d("Token", MyDBContainer.ACCESS_TOKEN)

                } catch (e: Exception) {
                    Log.d("Register Error", e.message.toString())
                }

                // TODO: Implement your registration logic here
                navController.navigate(ListScreen.Masuk.name)

                // After registration, you can perform additional actions if needed
            }
        } else {
            // Handle validation errors or show a message to the user
            navController.navigate(ListScreen.Daftar.name)
        }
    }

    private fun validateForm(): Boolean {
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
