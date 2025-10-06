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
fun AccountScreen(
    navController: NavHostController,
    innerPaddingBar: PaddingValues,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
) {
    Scaffold(
        bottomBar = {
            CustomNavigationBottomBar(navController, selectedItem, onItemClick = onItemSelected)
        }
    ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Экран заглушка",
                    color = Color.Gray,
                    fontFamily = Roboto
                )
            }

    }
}
