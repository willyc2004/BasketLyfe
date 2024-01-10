package com.example.basketlyfe.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basketlyfe.R
import com.example.basketlyfe.components.TextBoldMod
import com.example.basketlyfe.components.TextExtraBold

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen() {
    Scaffold {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(24.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextExtraBold(
                    value = "Profile",
                    textColor = Color(0xFF6D41A0),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Row {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = Color(0xFF6D41A0))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(150.dp)
                                .clip(RoundedCornerShape(size = 100.dp))
                        )
                        Column(
                            modifier = Modifier
                                .padding(top = 30.dp, start = 140.dp, bottom = 9.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                TextBoldMod(value = "Justin", textColor = Color.White, modifier = Modifier, size = 16)
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TextBoldMod(value = "Justin@gmail.com", textColor = Color.White, modifier = Modifier, size = 16)
                            }
                        }
                    }
                }

                ProfileMenuItem("Ganti Nama") { }
                ProfileMenuItem("Log Out") { }
            }
        }
    }
}

@Composable
fun ProfileMenuItem(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick) // Clickable modifier here
            .padding(start = 16.dp, end = 16.dp, top = 25.dp, bottom = 25.dp)
    ) {
        TextBoldMod(value = text, textColor = Color(0xFF6D41A0), modifier = Modifier, size = 20)
    }

    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilePreview() {
    ProfileScreen()
}