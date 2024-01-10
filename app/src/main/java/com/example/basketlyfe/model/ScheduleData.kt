package com.example.basketlyfe.model

import com.example.basketlyfe.R

object ScheduleData {
    val schedule =
        ScheduleListModel(
            id = 1,
            name = "Lapangan 1",
            image = R.drawable.p1,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Amerika",
            date = "14 Januari",
            time = "14.00-16.00"

        )
    val schduleList = listOf(
        schedule,
        ScheduleListModel(
            id = 2,
            name = "Lapangan 2",

            image = R.drawable.p2,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Malaysia",
            date = "15 Januari",
            time = "18.00-20.00"
        ),
        ScheduleListModel(
            id = 3,
            name = "Lapangan 3",

            image = R.drawable.p3,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,India",
            date = "12 Januari",
            time = "10.00-12.00"
        ),
        ScheduleListModel(
            id = 4,
            name = "Lapangan 4",

            image = R.drawable.p4,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Korea",
            date = "19 Januari",
            time = "14.00-16.00"

        ),
        ScheduleListModel(
            id = 5,
            name = "Lapangan 5",

            image = R.drawable.p5,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Indonesia",
            date = "19 Januari",
            time = "16.00-18.00"
        ),
        ScheduleListModel(
            id = 6,
            name = "Lapangan 6",

            image = R.drawable.p6,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Indonesia",
            date = "20 Januari",
            time = "19.00-21.00"
        )
    )
}