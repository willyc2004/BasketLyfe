package com.example.basketlyfe.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basketlyfe.R
import com.example.basketlyfe.ui.theme.Prompt
import com.example.basketlyfe.viewmodel.LoadingScreenViewModel
import kotlinx.coroutines.launch

// LoadingScreen.kt

@Composable
fun LoadingScreen(viewModel: LoadingScreenViewModel) {
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        // Use a coroutine scope to launch a background task
        scope.launch {
            // Simulate loading
            viewModel.simulateLoading()

            // Navigate to the Masuk screen after the loading is complete
            viewModel.onLoadingDone()
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "image description",
            contentScale = ContentScale.None
        )

        Text(
            text = "BasketLyfe",
            style = TextStyle(
                fontSize = 40.sp,
                lineHeight = 20.sp,
                fontFamily = Prompt,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Black,
                color = Color(0xFFED6C30),
                textAlign = TextAlign.Center,
                letterSpacing = 2.sp
            )
        )
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LoadingScreenPreview() {
//    LoadingScreen()
//}