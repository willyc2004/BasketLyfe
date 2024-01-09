package com.example.basketlyfe.Model

import com.example.basketlyfe.R

object CompetitionData {
    val competition =
        CompetitionListModel(
            id = 1,
            name = "KoBasMa",
            description = "Kompetisi Basket Mahasiswa yang diselenggarakan oleh Universitas Duibe",
            image = R.drawable.p1,
            address = "Jalan Sidoardjo No 2, Amerika",
            max_tim = "8",
            mulai = "1 Januari 2024",
            selesai= "12 Januari 2024",
            harga= "Rp60.000",
        )
    val competitionList = listOf(
        competition,
        CompetitionListModel(
            id = 2,
            name = "KoBaSis",
            description = "Kompetisi Basket Siswa yang diselenggarakan oleh SMA Negri 1",
            image = R.drawable.p2,
            address = "Jalan Durian Runtuh No 32, Malaysia",
            max_tim = "9",
            mulai = "7 Januari 2024",
            selesai= "29 Januari 2024",
            harga= "Rp80.000",
        ),
        CompetitionListModel(
            id = 3,
            name = "UCBC",
            description = "Universitas Ciputra Basket Competition yang diselenggarakan oleh Universitas Ciputra",
            image = R.drawable.p3,
            address = "Jalan Menuju Surga No 1, India",
            max_tim = "7",
            mulai = "7 Februari 2024",
            selesai= "27 Februari 2024",
            harga= "Rp120.000",
        ),
        CompetitionListModel(
            id = 4,
            name = "KoBasMi",
            description = "Kompetisi Basket Mahasiswi yang diselenggarakan oleh Universitas Mandai",
            image = R.drawable.p4,
            address = "Jalan Mawar No 22, Korea",
            max_tim = "10",
            mulai = "8 Januari 2024",
            selesai= "15 Januari 2024",
            harga= "Rp90.000",
        ),
        CompetitionListModel(
            id = 5,
            name = "Basket Cup",
            description = "Kompetisi Basket Mahasiswa & Mahasiswi yang diselenggarakan oleh Universitas Pulu",
            image = R.drawable.p5,
            address = "Jalan Pulu-Pulu No 6, Indonesia",
            max_tim = "7",
            mulai = "12 Januari 2024",
            selesai= "19 Januari 2024",
            harga= "Rp130.000",
        ),
        CompetitionListModel(
            id = 6,
            name = "KBMI",
            description = "Kompetisi Basket Mahasiswa/i Indonesia yang diselenggarakan oleh Pemerintah",
            image = R.drawable.p6,
            address = "Jalan Melati No 7, Singapore",
            max_tim = "8",
            mulai = "13 Januari 2024",
            selesai= "19 Januari 2024",
            harga= "Rp60.000",
        )
    )
}