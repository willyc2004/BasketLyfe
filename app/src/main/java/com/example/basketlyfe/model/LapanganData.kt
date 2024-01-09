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
            price = "Rp75.000/jam",
            fasilitas = "1. Lapangan Kayu" +
                    "2. AC" +
                    "3. Toilet"
        )
    val lapanganList = listOf(
        lapangan,
        LapanganListModel(
            id = 2,
            name = "Lapangan 2",
            rate = "3/5 dari 231 orang",
            image = R.drawable.p2,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Malaysia",
            price = "Rp55.000/jam",
            fasilitas = "1. Lapangan Karet" +
                    "2. Kipas Angin" +
                    "3. Toilet"
        ),
        LapanganListModel(
            id = 3,
            name = "Lapangan 3",
            rate = "5/5 dari 833 orang",
            image = R.drawable.p3,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,India",
            price = "Rp60.000/jam",
            fasilitas = "1. Lapangan Beton" +
                    "2. AC" +
                    "3. Toilet" +
                    "4. Kantin"
        ),
        LapanganListModel(
            id = 4,
            name = "Lapangan 4",
            rate = "4.5/5 dari 97 orang",
            image = R.drawable.p4,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Korea",
            price = "Rp80.000/jam",
            fasilitas = "1. Lapangan Karet" +
                    "2. Kipas Angin" +
                    "3. Toilet" +
                    "4. Kantin"
        ),
        LapanganListModel(
            id = 5,
            name = "Lapangan 5",
            rate = "3.5/5 dari 201 orang",
            image = R.drawable.p5,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Indonesia",
            price = "Rp100.000/jam",
            fasilitas = "1. Lapangan Beton" +
                    "2. Toilet"
        ),
        LapanganListModel(
            id = 6,
            name = "Lapangan 6",
            rate = "4.7/5 dari 328 orang",
            image = R.drawable.p6,
            address = "Jalan Mejikuhibiniu No 1, 2-3 Sidoarjo,Indonesia",
            price = "Rp45.000/jam",
            fasilitas = "1. Lapangan Kayu" +
                    "2. AC" +
                    "3. Toilet"
        )
    )
}