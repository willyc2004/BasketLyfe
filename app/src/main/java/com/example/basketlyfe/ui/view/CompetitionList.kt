package com.example.basketlyfe.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basketlyfe.ViewModel.Competition
import com.example.basketlyfe.ViewModel.CompetitionCard
import com.example.basketlyfe.ViewModel.generateDummyCompetitionListData
import com.example.basketlyfe.ui.theme.BasketLyfeTheme

class CompetitionList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            BasketLyfeTheme{
                UserScreen()
            }
        }
    }
    @Composable
    fun UserScreen() {
        val totalData = 50
        val users = remember {
            generateDummyCompetitionListData(totalData)
        }
        val ctx = LocalContext.current

        LazyColumn {
            item {
                Text(
                    text = "Competition",
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
            item {

            }
            itemsIndexed(items = users) { index, item ->
                CompetitionCard(competition = item) {
                    Toast.makeText(ctx, item.name, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}