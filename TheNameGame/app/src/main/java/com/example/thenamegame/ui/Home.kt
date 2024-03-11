package com.example.thenamegame.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thenamegame.data.ApiService
import com.example.thenamegame.data.RetrofitService
import com.example.thenamegame.data.TheNameGameRepository
import com.example.thenamegame.data.TheNameResponse
import com.example.thenamegame.domain.TheNameGameRepositoryImpl
import retrofit2.Retrofit

private const val BASE_URL = " https://namegame.willowtreeapps.com/api"

@Composable
fun HomeScreen() {
    val apiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(RetrofitService.logger)
        .build()
        .create(ApiService::class.java)
    val repository = TheNameGameRepositoryImpl(apiService = apiService)
    val viewModel = TheViewModel(repository)
    val uiState by viewModel.uiState.collectAsState()

    HeadShotList(uiState.employes)


}

@Composable
fun HeadShotList(employList: List<TheNameResponse>) {

    Column {
        Row {
            Text(text = "name")
        }
        Column {
            LazyVerticalGrid(columns = GridCells.FixedSize(128.dp)) {
                item(employList) {

                    employList.forEach { nameResponse ->
                        EmployeListItem(firstName = nameResponse.firstName)

                    }
                }
            }

        }
    }
    employList.forEach { nameResponse ->
        nameResponse.firstName

    }
}

@Composable
fun EmployeListItem(firstName: String) {
    Text(text = firstName)

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()

}