package com.example.basketlyfe.viewmodel


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.basketlyfe.Model.CompetitionListModel

@Composable
fun CompetitionCard(
    competition: CompetitionListModel,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(top = 18.dp, bottom = 18.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate("detail/${competition.id}")
            },
        shape = MaterialTheme.shapes.medium
    ) {
        Column {
            Image(painter = painterResource(id = competition.image),
                contentDescription = null, // Set a meaningful content description
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), // Adjust the height as needed
                contentScale = ContentScale.Crop
            )
            Text(
                text = competition.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            Row {
                Icon(Icons.Rounded.LocationOn, contentDescription = "Address",
                    modifier = Modifier
                        .padding(PaddingValues(start = 5.dp, bottom = 9.dp)))
                Text(
                    text = competition.address,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(top = 1.dp, start = 5.dp, bottom = 2.dp)
                        .fillMaxWidth()
                )
            }

        }
    }
}