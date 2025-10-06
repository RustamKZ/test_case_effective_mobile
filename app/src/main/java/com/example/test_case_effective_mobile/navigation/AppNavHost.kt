package com.example.test_case_effective_mobile.navigation

import AccountScreen
import FavoritesScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test_case_effective_mobile.api.CoursesViewModel
import com.example.test_case_effective_mobile.screens.AuthorizationScreen
import com.example.test_case_effective_mobile.screens.MainScreen

@Composable
fun AppNavHost(
    innerPadding: PaddingValues,
    navController: NavHostController = rememberNavController(),
) {
    var selectedItem by rememberSaveable { mutableStateOf(0) }
    val coursesViewModel: CoursesViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = "authorization"
    ) {
        composable("authorization") {
            AuthorizationScreen(
                Modifier.padding(innerPadding), navController
            )
        }
        composable("home") {
            MainScreen(
                navController,
                innerPadding,
                coursesViewModel,
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it })
        }
        composable("favorites") { FavoritesScreen(
            navController,
            innerPadding,
            coursesViewModel,
            selectedItem = selectedItem,
            onItemSelected = { selectedItem = it }) }

        composable("account") { AccountScreen(
            navController,
            innerPadding,
            selectedItem = selectedItem,
            onItemSelected = { selectedItem = it }) }
    }
}