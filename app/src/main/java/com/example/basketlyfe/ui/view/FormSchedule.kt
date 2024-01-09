@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.basketlyfe.ui.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.basketlyfe.components.TextBoldMod
import com.example.basketlyfe.components.TextExtraBold
import com.example.basketlyfe.components.TextField
import com.example.basketlyfe.viewmodel.FormScheduleViewModel
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.date_time.DateTimeDialog
import com.maxkeppeler.sheets.date_time.models.DateTimeSelection
import com.maxkeppeler.sheets.option.OptionDialog
import com.maxkeppeler.sheets.option.models.DisplayMode
import com.maxkeppeler.sheets.option.models.Option
import com.maxkeppeler.sheets.option.models.OptionConfig
import com.maxkeppeler.sheets.option.models.OptionSelection
import java.time.LocalTime


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FormSchedule(viewModel: FormScheduleViewModel) {
    val selectedTime = remember { mutableStateOf<LocalTime?>(LocalTime.now()) }
    val clockState = rememberUseCaseState()
    val optionState = rememberUseCaseState()
    DateTimeDialog(
        state = clockState,
        selection = DateTimeSelection.Time (
            selectedTime = selectedTime.value
        ) {newTime ->
            selectedTime.value = newTime
        }
    )

    val options = listOf(
        Option(
            titleText = "2 Jam",
            selected = true
        ),
        Option(
            titleText = "4 Jam",
//            disabled = true
        ),
        Option(
            titleText = "6 Jam",
//            details = OptionDetails(
//                "Ananas comosus",
//                "The pineapple is a tropical plant with an edible fruit; it is the most economically significant plant in the family Bromeliaceae."
//            )
        ),

        )

    OptionDialog(
        state = optionState,
        selection = OptionSelection.Single(options) { index, option ->
            // Handle selection
        },
        config = OptionConfig(mode = DisplayMode.LIST)
    )
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextExtraBold(value = "Form Daftar Schedule", textColor = Color(0xffED6C30), modifier = Modifier)
            Spacer(modifier = Modifier.height(16.dp))
            TextBoldMod(value = "Nama Lengkap", textColor = Color(0xffED6C30), modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 10.dp), size = 20)
            TextField(value = viewModel.name, onValueChange = {viewModel.name = it}, placeHolder = "Nama Lengkap")

            Spacer(modifier = Modifier.height(16.dp))
            TextBoldMod(value = "Max Player", textColor = Color(0xffED6C30), modifier = Modifier
                .align(Alignment.Start)
                .padding(horizontal = 10.dp), size = 20)
            TextField(value = viewModel.maxPlayer, onValueChange = {viewModel.maxPlayer = it}, placeHolder = "Max Player")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                clockState.show()
            }) {
                Text(text = "Time Start")
            }

            Button(onClick = {
                optionState.show()
            }) {
                Text(text = "Berapa Jam?")
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FormSchedulePreview() {
    val navController = rememberNavController()
    FormSchedule(viewModel = FormScheduleViewModel(navController = navController))
}