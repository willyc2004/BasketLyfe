package com.example.basketlyfe.ViewModel


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
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

class Competition: ViewModel(){
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _compe = MutableStateFlow(listOf<CompetitionListModel>())
    val compe = searchText
        .combine(_compe){
                text, compe ->
            if(text.isBlank()){
                compe
            }else{
                compe.filter {
                    it.doesMatchSearch(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(1000),
            _compe.value
        )
    fun onSearchTextChange(text: String){
        _searchText.value = text
    }
}
fun generateDummyCompetitionListData(totalData: Int) : MutableList<CompetitionListModel>{
    val list = mutableListOf<CompetitionListModel>()
    for (i in 1 ..totalData){
        list.add(CompetitionListModel(name = "Competition: $i"))
    }
    return list
}

@Composable
fun CompetitionCard(
    competition: CompetitionListModel,
    onClick: ()-> Unit
){
    Card (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable (onClick = onClick),
        shape = MaterialTheme.shapes.medium
    ){
        Text(
            text = competition.name,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        )

    }
}