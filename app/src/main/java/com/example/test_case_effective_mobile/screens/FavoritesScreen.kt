import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.test_case_effective_mobile.api.CoursesViewModel
import com.example.test_case_effective_mobile.design.CustomCourseCard
import com.example.test_case_effective_mobile.design.CustomNavigationBottomBar
import com.example.test_case_effective_mobile.ui.theme.Roboto

@Composable
fun FavoritesScreen(
    navController: NavHostController,
    innerPaddingBar: PaddingValues,
    viewModel: CoursesViewModel = viewModel(),
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
) {
    val courses by viewModel.courses.collectAsState()
    val likedIds by viewModel.likedIds.collectAsState()

    val favoriteCourses = remember(courses, likedIds) {
        courses.filter { likedIds.contains(it.id) }
    }

    Scaffold(
        topBar = {
            Text(
                text = "Избранное",
                fontSize = 28.sp,
                color = Color.White,
                fontFamily = Roboto,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(innerPaddingBar).padding(horizontal = 16.dp)
            )
        },
        bottomBar = {
            CustomNavigationBottomBar(navController, selectedItem, onItemClick = onItemSelected)
        }
    ) { innerPadding ->
        if (favoriteCourses.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Пока нет избранных курсов",
                    color = Color.Gray,
                    fontFamily = Roboto
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(favoriteCourses) { course ->
                    CustomCourseCard(course, true) { clicked ->
                        viewModel.toggleLike(clicked.id)
                    }
                }
            }
        }
    }
}
