@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.basketlyfe.ui.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.basketlyfe.R
import com.example.basketlyfe.components.BackIcon
import com.example.basketlyfe.components.CalendarApp
import com.example.basketlyfe.components.FAB
import com.example.basketlyfe.components.ImageBorder
import com.example.basketlyfe.components.Reminder
import com.example.basketlyfe.components.Schedule
import com.example.basketlyfe.components.TextBoldMod
import com.example.basketlyfe.components.TextNormal


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateSchedule(navController: NavController) {
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
            BackIcon(
                imageResId = R.drawable.back,
                onClick = {
                    // Handle back icon click
                },
                Modifier
                    .size(32.dp)
                    .clickable { }
                    .align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), // Adjust the padding as needed
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextBoldMod(value = "Nama Lapangan 1", textColor = Color(0xFF6D41A0), modifier = Modifier, size = 24)

                ImageBorder(
                    imageResId = R.drawable.lapangan,
                    borderResId = R.drawable.border,
                    size = 70,
                    modifier = Modifier.background(Color.Transparent)
                )
            }

            CalendarApp()
            Spacer(modifier = Modifier.height(4.dp))
            TextBoldMod(value = "Schedule", textColor = Color.Black, modifier = Modifier.align(Alignment.Start), size = 20)
            Spacer(modifier = Modifier.height(16.dp))

            //ini foreach ya
            Schedule(
                name = "Willy",
                start = "14.00",
                end = "16.00"
            )

            //slesai

            Spacer(modifier = Modifier.height(16.dp))
            TextBoldMod(value = "Reminder", textColor = Color.Black, modifier = Modifier.align(Alignment.Start), size = 20)
            TextNormal(value = "Don't forget schedule for tomorrow", textColor = Color(0xFF94A3B8), modifier = Modifier.align(Alignment.Start))

            Spacer(modifier = Modifier.height(16.dp))
            Reminder(
                title = "Booked Lapangan 1",
                date = "December 22",
                start = "12.00",
                end = "14.00"
            )

            FAB(onClick = { /*TODO*/ }, size = 60)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateSchedulePreview() {
    val navController = rememberNavController()
    CreateSchedule(
        navController = navController
    )
}