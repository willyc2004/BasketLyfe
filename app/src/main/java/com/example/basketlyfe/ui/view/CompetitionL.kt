package com.example.basketlyfe.ui.view

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basketlyfe.Model.CompetitionData
import com.example.basketlyfe.ViewModel.CompetitionCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompetitionLScreen(){
    val competitionList = remember {
        CompetitionData.competitionList
    }
    val ctx = LocalContext.current

    var searchQuery by remember { mutableStateOf("") }

    val filteredList = competitionList.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    LazyColumn {
        item {
            Text(
                text = "Competition List",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.15.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
                    .padding(vertical = 16.dp),
                textAlign = TextAlign.Center
            )
        }

        // Search bar
        item {
            TextField(
                value = searchQuery,
                onValueChange = {
                    searchQuery = it
                },
                label = { Text("Search") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }

        // Display the filtered list
        itemsIndexed(items = filteredList) { _, item ->
            CompetitionCard(competition = item) {
                Toast.makeText(ctx, item.name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}