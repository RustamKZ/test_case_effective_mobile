package com.example.test_case_effective_mobile.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.test_case_effective_mobile.R
import com.example.test_case_effective_mobile.api.CoursesViewModel
import com.example.test_case_effective_mobile.design.CustomCourseCard
import com.example.test_case_effective_mobile.design.CustomNavigationBottomBar
import com.example.test_case_effective_mobile.ui.theme.CustomGreen
import com.example.test_case_effective_mobile.ui.theme.Roboto
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun MainScreen(
    navController: NavHostController,
    innerPaddingBar: PaddingValues,
    viewModel: CoursesViewModel = viewModel(),
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
) {
    val searchState = rememberTextFieldState()
    val courses by viewModel.courses.collectAsState()
    val likedIds by viewModel.likedIds.collectAsState()
    var isDescending by remember { mutableStateOf(true) }
    val dateFormat = remember { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) }
    val sortedCourses = remember(courses, isDescending, likedIds) {
        courses
            .map { it.copy(hasLike = likedIds.contains(it.id)) }
            .sortedByDescending { dateFormat.parse(it.publishDate)?.time ?: 0L }
            .let { if (isDescending) it else it.reversed() }
    }

    Scaffold(
        topBar = {
            CustomNavigationBottomBar(searchState, innerPaddingBar, onSearchClick = {}) {

            }
        },
        bottomBar = {
            CustomNavigationBottomBar(navController, selectedItem, onItemClick = onItemSelected)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .clickable {
                        isDescending = !isDescending
                    },
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "По дате добавления",
                    fontSize = 20.sp,
                    color = CustomGreen,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.sort),
                    contentDescription = "Filter",
                    tint = CustomGreen,
                    modifier = Modifier.size(16.dp)
                )
            }
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(sortedCourses) { course ->
                    CustomCourseCard(course) { clickedCourse ->
                        viewModel.toggleLike(clickedCourse.id)
                    }
                }
            }
        }
    }
}