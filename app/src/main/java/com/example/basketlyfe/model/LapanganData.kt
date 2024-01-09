package com.example.basketlyfe.model

import com.example.basketlyfe.R

object LapanganData {
    val lapangan =
        LapanganListModel(
            id = 1,
            name = "Lapangan 1",
            rate = "4/5 dari 512 orang",
            image = R.drawable.p1,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Amerika",
            fasilitas = ""
        )
    val lapanganList = listOf(
        lapangan,
        LapanganListModel(
            id = 2,
            name = "Lapangan 2",
            rate = "3/5 dari 231 orang",
            image = R.drawable.p2,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Malaysia",
            fasilitas = ""
        ),
        LapanganListModel(
            id = 3,
            name = "Lapangan 3",
            rate = "5/5 dari 833 orang",
            image = R.drawable.p3,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,India",
            fasilitas = ""
        ),
        LapanganListModel(
            id = 4,
            name = "Lapangan 4",
            rate = "4.5/5 dari 97 orang",
            image = R.drawable.p4,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Korea",
            fasilitas = ""
        ),
        LapanganListModel(
            id = 5,
            name = "Lapangan 5",
            rate = "3.5/5 dari 201 orang",
            image = R.drawable.p5,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Indonesia",
            fasilitas = ""
        ),
        LapanganListModel(
            id = 6,
            name = "Lapangan 6",
            rate = "4.7/5 dari 328 orang",
            image = R.drawable.p6,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Indonesia",
            fasilitas = ""
        )
    )
}