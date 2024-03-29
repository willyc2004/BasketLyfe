package com.example.basketlyfe.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.basketlyfe.components.ScheduleCard
import com.example.basketlyfe.components.TextExtraBold
import com.example.basketlyfe.components.TextNormal
import com.example.basketlyfe.model.ScheduleData

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleListScreen() {

    val scheduleList = remember {
        ScheduleData.schduleList
    }
    val ctx = LocalContext.current
    val navController = rememberNavController()

    var searchQuery by remember { mutableStateOf("") }

    val filteredList = scheduleList.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    Scaffold {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(0.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = 16.dp, // Add left padding
                        end = 16.dp,   // Add right padding
                        bottom = 55.dp
                    )
                ) {
                    item {
//                        Text(
//                            text = "List Kompetisi",
//                            style = TextStyle(f
//                                fontSize = 30.sp,
//                                fontWeight = FontWeight.Bold,
//                                letterSpacing = 0.15.sp,
//                                color = "#6D41A0".color
//                            ),
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .wrapContentSize(Alignment.Center)
//                                .padding(top = 28.dp, bottom = 15.dp),
//                            textAlign = TextAlign.Center
//                        )

                        TextExtraBold(
                            value = "List Schedule",
                            textColor = Color(0xFF6D41A0),
                            modifier = Modifier
                        )
                    }


                    // Search bar
                    item {
                        TextField(
                            value = searchQuery,
                            onValueChange = {
                                searchQuery = it
                            },
                            label = {
                                Row(
                                    Modifier.fillMaxWidth(),

                                    ) {
                                    Icon(
                                        Icons.Rounded.Search, contentDescription = "Search",
                                        modifier = Modifier
                                            .padding(PaddingValues(start = 5.dp, bottom = 2.dp))
                                    )

                                    TextNormal(
                                        value = "Cari Kompetisi",
                                        textColor = Color.Black,
                                        modifier = Modifier
                                    )
                                }

                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFD0BCFF),
                                    shape = RoundedCornerShape(8.dp)
                                )
                        )
                    }

                    // Display the filtered list
                    itemsIndexed(items = filteredList) { _, item ->
                        ScheduleCard(schedule = item, navController = navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScheduleListPreview() {
    ScheduleListScreen()
}