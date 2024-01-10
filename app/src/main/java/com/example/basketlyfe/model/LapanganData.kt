package com.example.basketlyfe.model

import com.example.basketlyfe.R

object LapanganData {
    val lapangan =
        LapanganListModel(
            id = 1,
            name = "GOR CLS Kertajaya",
            rate = "4.5/5 dari 512 orang",
            image = R.drawable.p1,
            address = "GOR CLS Kertajaya, Kertajaya",
            price = "Rp 500.000/jam",
            fasilitas = "1. Lapangan Kayu" +
                    "2. AC" +
                    "3. Toilet"
        )
    val lapanganList = listOf(
        lapangan,
        LapanganListModel(
            id = 2,
            name = "GOR GMC Cirebon",
            rate = "4.2/5 dari 231 orang",
            image = R.drawable.p2,
            address = "GOR GMC Cirebon, Cirebon",
            price = "Rp600.000/jam",
            fasilitas = "1. Lapangan Karet" +
                    "2. Kipas Angin" +
                    "3. Toilet"
        ),
        LapanganListModel(
            id = 3,
            name = "NextGen Surabaya",
            rate = "5/5 dari 833 orang",
            image = R.drawable.p3,
            address = "Ciputra World",
            price = "Rp600.000/jam",
            fasilitas = "1. Lapangan Beton" +
                    "2. AC" +
                    "3. Toilet" +
                    "4. Kantin"
        ),
        LapanganListModel(
            id = 4,
            name = "Mayasi Surabaya",
            rate = "4.5/5 dari 97 orang",
            image = R.drawable.p4,
            address = "Jalan Kenjeran No 1-4",
            price = "Rp700.000/jam",
            fasilitas = "1. Lapangan Karet" +
                    "2. Kipas Angin" +
                    "3. Toilet" +
                    "4. Kantin"
        ),
        LapanganListModel(
            id = 5,
            name = "Bimasakti Malang",
            rate = "4.5/5 dari 201 orang",
            image = R.drawable.p5,
            address = "Jalan Batu Night, Malang",
            price = "Rp500.000/jam",
            fasilitas = "1. Lapangan Beton" +
                    "2. Toilet"
        ),
        LapanganListModel(
            id = 6,
            name = "Bimasakti Batu",
            rate = "4.7/5 dari 328 orang",
            image = R.drawable.p6,
            address = "Jalan Hangry Kitten, Batu",
            price = "Rp450.000/jam",
            fasilitas = "1. Lapangan Kayu" +
                    "2. AC" +
                    "3. Toilet"
        )
    )
}