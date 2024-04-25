package com.yeonberry.flicks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.yeonberry.flicks.model.Movie
import com.yeonberry.flicks.search.SearchScreen
import com.yeonberry.flicks.ui.theme.FlicksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlicksTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SearchScreen(
                        listOf(
                            Movie(
                                name = "범죄도시4",
                                releaseDate = "2024.04.24",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시3",
                                releaseDate = "2023.05.31",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시2",
                                releaseDate = "2022.05.18",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시",
                                releaseDate = "2017.10.03",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시4",
                                releaseDate = "2024.04.24",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시3",
                                releaseDate = "2023.05.31",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시2",
                                releaseDate = "2022.05.18",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시",
                                releaseDate = "2017.10.03",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시4",
                                releaseDate = "2024.04.24",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시3",
                                releaseDate = "2023.05.31",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시2",
                                releaseDate = "2022.05.18",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시",
                                releaseDate = "2017.10.03",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시4",
                                releaseDate = "2024.04.24",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시3",
                                releaseDate = "2023.05.31",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시2",
                                releaseDate = "2022.05.18",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                            Movie(
                                name = "범죄도시",
                                releaseDate = "2017.10.03",
                                posterPath = "",
                                genreIds = emptyList()
                            ),
                        )
                    )
                }
            }
        }
    }
}
