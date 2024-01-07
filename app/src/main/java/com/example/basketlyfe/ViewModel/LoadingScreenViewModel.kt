package com.example.basketlyfe.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.basketlyfe.ui.ListScreen
import kotlinx.coroutines.delay

class LoadingScreenViewModel(private val navController: NavController) : ViewModel() {
    // LiveData or MutableState to represent the loading state
    // For simplicity, I'll use a MutableState here
    private val isLoading = mutableStateOf(true)

    suspend fun simulateLoading() {
        // Simulate a 3-second delay
        delay(3000)

        // Set loading state to false after the delay
        isLoading.value = false
    }

    fun onLoadingDone() {
        // Handle any logic related to the Daftar button click
        navController.navigate(ListScreen.Masuk.name)
    }
}