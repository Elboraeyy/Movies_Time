package com.example.moviestime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieMiniTheme {
                MoviesApp()
            }
        }
    }
}

@Preview
@PreviewScreenSizes
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesApp() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Home", "Discover", "Profile")
    val icons = listOf(Icons.Default.Home, Icons.Default.Explore, Icons.Default.Person)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.backkkkk),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.8f)
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            "Movies Time",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent
                    ),
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color.White
                            )
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar(
                    containerColor = Color.Black.copy(alpha = 0.7f)
                ) {
                    tabs.forEachIndexed { index, title ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    icons[index],
                                    contentDescription = title,
                                    tint = if (selectedTab == index) MaterialTheme.colorScheme.primary else Color.White.copy(alpha = 0.7f)
                                )
                            },
                            label = {
                                Text(
                                    title,
                                    color = if (selectedTab == index) MaterialTheme.colorScheme.primary else Color.White.copy(alpha = 0.7f)
                                )
                            },
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.White.copy(alpha = 0.2f)
                            )
                        )
                    }
                }
            },
            containerColor = Color.Transparent
        ) { padding ->
            Box(Modifier.padding(padding)) {
                when (selectedTab) {
                    0 -> HomeScreen()
                    1 -> DiscoverScreen()
                    2 -> ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val featuredMovies = listOf(
        Movie("Shawshank Redemption", "1994", "Drama", 4.9f, 142, R.drawable.shawshank),
        Movie("Memento", "2000", "Mystery", 4.6f, 113, R.drawable.memento),
        Movie("Inception", "2010", "Sci-Fi", 4.8f, 148, R.drawable.inception),
        Movie("Shutter Island", "2010", "Thriller", 4.7f, 138, R.drawable.shutter_island),
        Movie("Seven", "1995", "Crime", 4.8f, 127, R.drawable.seven)
    )

    val series = listOf(
        Movie("Dexter", "2006", "Crime", 4.5f, 60, R.drawable.dexter),
        Movie("Prison Break", "2005", "Drama", 4.6f, 45, R.drawable.prison_break),
        Movie("The Summer I Turned Pretty", "2022", "Romance", 4.1f, 50, R.drawable.summer_pretty),
        Movie("The Walking Dead", "2010", "Horror", 4.3f, 60, R.drawable.walking_dead),
        Movie("Better Call Saul", "2015", "Drama", 4.7f, 47, R.drawable.better_call_saul),
        Movie("Breaking Bad", "2008", "Crime", 4.9f, 47, R.drawable.breaking_bad)
    )

    val trending = listOf(
        Movie("Fight Club", "1999", "Drama", 4.6f, 139, R.drawable.fight_club),
        Movie("Dune: Part Two", "2024", "Sci-Fi", 4.8f, 166, R.drawable.dune2),
        Movie("Arrival", "2016", "Sci-Fi", 4.5f, 116, R.drawable.arrival),
        Movie("Prisoners", "2013", "Thriller", 4.6f, 153, R.drawable.prisoners),
        Movie("Gone Girl", "2014", "Mystery", 4.5f, 149, R.drawable.gone_girl)
    )

    val popular = listOf(
        Movie("The Maze Runner", "2014", "Action", 4.3f, 113, R.drawable.maze_runner),
        Movie("Don't Breathe", "2016", "Horror", 4.2f, 88, R.drawable.dont_breathe),
        Movie("A Quiet Place", "2018", "Horror", 4.4f, 90, R.drawable.quiet_place),
        Movie("Nightcrawler", "2014", "Thriller", 4.4f, 118, R.drawable.nightcrawler),
        Movie("Heat", "1995", "Action", 4.5f, 170, R.drawable.heat)
    )

    val topRated = listOf(
        Movie("Django Unchained", "2012", "Western", 4.5f, 165, R.drawable.django),
        Movie("Interstellar", "2014", "Sci-Fi", 4.7f, 169, R.drawable.interstellar),
        Movie("Oppenheimer", "2023", "Biography", 4.7f, 180, R.drawable.oppenheimer),
        Movie("The Godfather", "1972", "Crime", 4.9f, 175, R.drawable.godfather),
        Movie("Forrest Gump", "1994", "Drama", 4.8f, 142, R.drawable.forrest_gump)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(featuredMovies) { movie ->
                    FeaturedLargeCard(movie = movie)
                }
            }
        }

        item { SectionWithRow(title = "🎯 Series", movies = series) }
        item { SectionWithRow(title = "🔥 Trending", movies = trending) }
        item { SectionWithRow(title = "🏆 Top Rated", movies = topRated) }
        item { SectionWithRow(title = "⭐ Popular", movies = popular) }
    }
}

@Composable
fun FeaturedLargeCard(movie: Movie) {
    Box(
        modifier = Modifier
            .width(280.dp)
            .height(320.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Image(
            painter = painterResource(id = movie.imageRes),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(20.dp))
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
                .background(Color.Black.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                .padding(12.dp)
        ) {
            Text(
                text = movie.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "${movie.genre} • ${movie.year} • ${movie.duration} min",
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 13.sp
            )

            Spacer(Modifier.height(8.dp))

            Button(
                onClick = {},
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107))
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = "Play")
                Spacer(Modifier.width(6.dp))
                Text("Watch Now", color = Color.Black)
            }
        }
    }
}

@Composable
fun SectionWithRow(title: String, movies: List<Movie>) {
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            TextButton(onClick = {}) {
                Text(
                    "See All",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(Modifier.height(8.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(movies) { movie ->
                MovieCardSmall(movie = movie)
            }
        }
    }
}

@Composable
fun MovieCardSmall(movie: Movie) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .height(240.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.DarkGray.copy(alpha = 0.7f))
    ) {
        Image(
            painter = painterResource(id = movie.imageRes),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(16.dp))
        )

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = movie.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )

            Text(
                text = "${movie.year} • ${movie.genre}",
                fontSize = 12.sp,
                color = Color.White.copy(alpha = 0.7f),
            )
        }
    }
}

@Composable
fun DiscoverScreen() {
    val genres = listOf("Action", "Comedy", "Drama", "Horror", "Sci-Fi", "Romance", "Thriller", "Adventure")
    val trendingMovies = listOf(
        Movie("Dune: Part Two", "2024", "Sci-Fi", 4.8f, 166, R.drawable.dune2),
        Movie("Oppenheimer", "2023", "Biography", 4.7f, 180, R.drawable.oppenheimer),
        Movie("Prisoners", "2013", "Thriller", 4.6f, 153, R.drawable.prisoners),
        Movie("Gone Girl", "2014", "Mystery", 4.5f, 149, R.drawable.gone_girl)
    )

    val recommended = listOf(
        Movie("Inception", "2010", "Sci-Fi", 4.8f, 148, R.drawable.inception),
        Movie("Interstellar", "2014", "Sci-Fi", 4.7f, 169, R.drawable.interstellar),
        Movie("A Quiet Place", "2018", "Horror", 4.4f, 90, R.drawable.quiet_place),
        Movie("Nightcrawler", "2014", "Thriller", 4.4f, 118, R.drawable.nightcrawler)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                "Discover Movies",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.height(12.dp))

            // Search Bar
            OutlinedTextField(
                value = "",
                onValueChange = {},
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White.copy(alpha = 0.7f))
                },
                placeholder = {
                    Text("Search movies, series, genres...", color = Color.White.copy(alpha = 0.5f))
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Black.copy(alpha = 0.4f),
                    unfocusedContainerColor = Color.Black.copy(alpha = 0.4f),
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = Color.White.copy(alpha = 0.3f)
                ),
                shape = RoundedCornerShape(16.dp)
            )
        }

        item {
            Spacer(Modifier.height(8.dp))
            Text(
                "Genres",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Spacer(Modifier.height(8.dp))

            // Genres Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.height(220.dp)
            ) {
                items(genres) { genre ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
                                        MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                                    )
                                )
                            )
                            .padding(16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            genre,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }

        item {
            SectionWithRow(title = "🔥 Trending Now", movies = trendingMovies)
        }

        item {
            SectionWithRow(title = "⭐ Recommended For You", movies = recommended)
        }
    }
}

@Composable
fun ProfileScreen() {
    val watchlist = listOf(
        Movie("Inception", "2010", "Sci-Fi", 4.8f, 148, R.drawable.inception),
        Movie("Forrest Gump", "1994", "Drama", 4.8f, 142, R.drawable.forrest_gump),
        Movie("Interstellar", "2014", "Sci-Fi", 4.7f, 169, R.drawable.interstellar)
    )

    val stats = mapOf(
        "Movies Watched" to "142",
        "Hours Watched" to "312",
        "Favorite Genre" to "Sci-Fi"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(48.dp)
                    )
                }
                Spacer(Modifier.height(16.dp))
                Text(
                    "John Doe",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.White
                )
                Text(
                    "john.doe@example.com",
                    color = Color.White.copy(alpha = 0.7f)
                )

                Spacer(Modifier.height(20.dp))

                // Stats
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    stats.forEach { (key, value) ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                value,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                key,
                                fontSize = 12.sp,
                                color = Color.White.copy(alpha = 0.7f)
                            )
                        }
                    }
                }
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit Profile")
                    Spacer(Modifier.width(6.dp))
                    Text("Edit Profile", color = Color.Black)
                }

                Button(
                    onClick = {},
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray.copy(alpha = 0.7f)
                    )
                ) {
                    Icon(Icons.Default.Settings, contentDescription = "Settings")
                    Spacer(Modifier.width(6.dp))
                    Text("Settings", color = Color.White)
                }
            }
        }

        item {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "My Watchlist",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                TextButton(onClick = {}) {
                    Text(
                        "View All",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(watchlist) { movie ->
                    MovieCardSmall(movie = movie)
                }
            }
        }

        item {
            Column {
                ListItem(
                    headlineContent = {
                        Text("Notifications", color = Color.White)
                    },
                    leadingContent = {
                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = "Notifications",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    trailingContent = {
                        Switch(
                            checked = true,
                            onCheckedChange = {},
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = MaterialTheme.colorScheme.primary,
                                checkedTrackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                            )
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = Color.Transparent
                    )
                )

                ListItem(
                    headlineContent = {
                        Text("Dark Mode", color = Color.White)
                    },
                    leadingContent = {
                        Icon(
                            Icons.Default.DarkMode,
                            contentDescription = "Dark Mode",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    trailingContent = {
                        Switch(
                            checked = true,
                            onCheckedChange = {},
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = MaterialTheme.colorScheme.primary,
                                checkedTrackColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                            )
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = Color.Transparent
                    )
                )

                ListItem(
                    headlineContent = {
                        Text("Help & Support", color = Color.White)
                    },
                    leadingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.Help,
                            contentDescription = "Help",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = Color.Transparent
                    )
                )

                ListItem(
                    headlineContent = {
                        Text("Logout", color = MaterialTheme.colorScheme.primary)
                    },
                    leadingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Logout",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    colors = ListItemDefaults.colors(
                        containerColor = Color.Transparent
                    )
                )
            }
        }
    }
}

data class Movie(
    val title: String,
    val year: String,
    val genre: String,
    val rating: Float,
    val duration: Int,
    val imageRes: Int
)

@Composable
fun MovieMiniTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Color(0xFFBB86FC),
            onPrimary = Color.Black,
            background = Color.Transparent,
            onBackground = Color.White
        ),
        typography = Typography(),
        content = content
    )
}