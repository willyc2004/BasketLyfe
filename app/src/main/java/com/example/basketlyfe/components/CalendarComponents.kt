package com.example.basketlyfe.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.basketlyfe.datasource.CalendarDataSource
import com.example.basketlyfe.model.CalendarUiModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Header(
    data: CalendarUiModel,
    // calbacks to click previous & back button should be registered outside
    onPrevClickListener: (LocalDate) -> Unit,
    onNextClickListener: (LocalDate) -> Unit,
) {
    Row {
//        Text(
//            // show "Today" if user selects today's date
//            // else, show the full format of the date
//            text = if (data.selectedDate.isToday) {
//                "Today"
//            } else {
//                data.selectedDate.date.format(
//                    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
//                )
//            },
//            modifier = Modifier
//                .weight(1f)
//                .align(Alignment.CenterVertically)
//        )
        TextBoldMod(
            value = if (data.selectedDate.isToday) {
                "Today"
            } else {
                data.selectedDate.date.format(
                    DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)
                )
            },
            textColor = Color(0xFF6D41A0),
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            size = 16
        )

        IconButton(onClick = {
            onPrevClickListener(data.startDate.date)
        }) {
            Icon(
                imageVector = Icons.Filled.ChevronLeft,
                contentDescription = "Back"
            )
        }
        IconButton(onClick = {
            onNextClickListener(data.endDate.date)
        }) {
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "Next"
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarApp(modifier: Modifier = Modifier) {
    val dataSource = CalendarDataSource()
    // we use `mutableStateOf` and `remember` inside composable function to schedules recomposition
    var calendarUiModel by remember { mutableStateOf(dataSource.getData(lastSelectedDate = dataSource.today)) }

    Column(modifier = modifier) {
        Header(
            data = calendarUiModel,
            onPrevClickListener = { startDate ->
                // refresh the CalendarUiModel with new data
                // by get data with new Start Date (which is the startDate-1 from the visibleDates)
                val finalStartDate = startDate.minusDays(1)
                calendarUiModel = dataSource.getData(
                    startDate = finalStartDate,
                    lastSelectedDate = calendarUiModel.selectedDate.date
                )
            },
            onNextClickListener = { endDate ->
                // refresh the CalendarUiModel with new data
                // by get data with new Start Date (which is the endDate+2 from the visibleDates)
                val finalStartDate = endDate.plusDays(2)
                calendarUiModel = dataSource.getData(
                    startDate = finalStartDate,
                    lastSelectedDate = calendarUiModel.selectedDate.date
                )
            }
        )
        Content(data = calendarUiModel, onDateClickListener = { date ->
            // refresh the CalendarUiModel with new data
            // by changing only the `selectedDate` with the date selected by User
            calendarUiModel = calendarUiModel.copy(
                selectedDate = date,
                visibleDates = calendarUiModel.visibleDates.map {
                    it.copy(
                        isSelected = it.date.isEqual(date.date)
                    )
                }
            )
        })
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ContentItem(
    date: CalendarUiModel.Date,
    onClickListener: (CalendarUiModel.Date) -> Unit, // still, callback should be registered from outside
) {
    Card(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 4.dp)
            .clickable { // making the element clickable, by adding 'clickable' modifier
                onClickListener(date)
            },
        colors = CardDefaults.cardColors(
            // background colors of the selected date
            // and the non-selected date are different
            containerColor = if (date.isSelected) {
                Color(0xFFED6C30)
            } else {
                Color.White
            }
        ),
    ) {
        Column(
            modifier = Modifier
                .width(60.dp)
                .height(80.dp)
                .padding(4.dp),
            verticalArrangement = Arrangement.Center
        ) {
//            Text(
//                text = date.date.dayOfMonth.toString(), // date "15", "16"
//                modifier = Modifier.align(Alignment.CenterHorizontally),
//                style = MaterialTheme.typography.bodyMedium,
//            )
            TextBold(
                value = date.date.dayOfMonth.toString(), // date "15", "16"
                textColor = if (date.isSelected) {
                    Color.White
                } else {
                    Color.Black
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )
//            Text(
//                text = date.day, // day "Mon", "Tue"
//                modifier = Modifier.align(Alignment.CenterHorizontally),
//                style = MaterialTheme.typography.bodySmall
//            )
            TextNormal(
                value = date.day, // day "Mon", "Tue",
                textColor = if (date.isSelected) {
                    Color.White
                } else {
                    Color.Black
                },
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Content(
    data: CalendarUiModel,
    // callback should be registered from outside
    onDateClickListener: (CalendarUiModel.Date) -> Unit,
) {
    LazyRow {
        // pass the visibleDates to the UI
        items(items = data.visibleDates) { date ->
            ContentItem(
                date = date,
                onDateClickListener
            )
        }
    }
}