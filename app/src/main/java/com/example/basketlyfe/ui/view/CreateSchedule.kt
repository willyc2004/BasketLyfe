@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.basketlyfe.ui.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import com.maxkeppeler.sheets.date_time.DateTimeDialog
import com.maxkeppeler.sheets.date_time.models.DateTimeSelection
import com.maxkeppeler.sheets.option.OptionDialog
import com.maxkeppeler.sheets.option.models.DisplayMode
import com.maxkeppeler.sheets.option.models.Option
import com.maxkeppeler.sheets.option.models.OptionConfig
import com.maxkeppeler.sheets.option.models.OptionSelection
import java.time.LocalDate
import java.time.LocalTime


@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun CreateSchedule(navController: NavController) {
    val selectedDate = remember { mutableStateOf<LocalDate?>(LocalDate.now()) }
    val calendarState = rememberUseCaseState()
    val weekCalendarState = rememberUseCaseState()
    val selectedTime = remember { mutableStateOf<LocalTime?>(LocalTime.now()) }
    val clockState = rememberUseCaseState()
    val optionState = rememberUseCaseState()

    CalendarDialog(
        state = calendarState,
        config = CalendarConfig(
            yearSelection = true,
            monthSelection = true,
            style = CalendarStyle.MONTH
        ),
        selection = CalendarSelection.Date(
            selectedDate = selectedDate.value
        ) { newDate ->
            selectedDate.value = newDate
        },
    )

    CalendarDialog(
        state = weekCalendarState,
        config = CalendarConfig(
            yearSelection = true,
            monthSelection = true,
            style = CalendarStyle.WEEK
        ),
        selection = CalendarSelection.Date(
            selectedDate = selectedDate.value
        ) { newDate ->
            selectedDate.value = newDate
        },
    )


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


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            calendarState.show()
        }) {
            Text(text = "Month Date Picker")
        }
        Button(onClick = {
            weekCalendarState.show()
        }) {
            Text(text = "Week Date Picker")
        }
        Button(onClick = {
            clockState.show()
        }) {
            Text(text = "Time Picker")
        }
        Button(onClick = {
            optionState.show()
        }) {
            Text(text = "Option Picker")
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