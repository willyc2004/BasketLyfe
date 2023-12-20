package com.example.basketlyfe.Model

data class CompetitionListModel(
    val name : String
) {
    fun doesMatchSearch(query: String): Boolean{
        "Kobe"
        val match = listOf(
            "$name"
        )
        return match.any{
            it.contains(query, ignoreCase = true)
        }
    }
    private val AllCompetitionList = listOf(
        CompetitionListModel(
            name = "KOBASMA"
        )
    )
}