package com.example.basketlyfe.ViewModel


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basketlyfe.Model.CompetitionListModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

@Composable
fun CompetitionCard(
    competition: CompetitionListModel,
    onClick: ()-> Unit
){
    Card (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
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
                Icon(Icons.Rounded.LocationOn, contentDescription = "Address", modifier = Modifier.padding(2.dp))
                Text(
                    text = competition.address,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(2.dp)
                        .fillMaxWidth()
                )
            }

        }
    }
}