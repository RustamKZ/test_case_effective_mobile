package com.example.test_case_effective_mobile.design

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.test_case_effective_mobile.R
import com.example.test_case_effective_mobile.ui.theme.CustomGray
import com.example.test_case_effective_mobile.ui.theme.CustomGreen
import com.example.test_case_effective_mobile.ui.theme.Roboto

@Composable
fun CustomNavigationBottomBar(
    navController: NavHostController,
    selectedItem: Int,
    onItemClick: (Int) -> Unit,
) {
    NavigationBar {
        NavigationBarItem(
            selected = selectedItem == 0,
            onClick = {
                onItemClick(0)
                navController.navigate("home") { launchSingleTop = true }
            },
            icon = {
                Icon(
                    painterResource(R.drawable.house),
                    contentDescription = "Главная",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Главная",
                    fontSize = 16.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.SemiBold
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = CustomGreen,
                unselectedIconColor = Color.White,
                selectedTextColor = CustomGreen,
                unselectedTextColor = Color.White,
                indicatorColor = CustomGray
            )
        )
        NavigationBarItem(
            selected = selectedItem == 1,
            onClick = {
                onItemClick(1)
                navController.navigate("favorites") { launchSingleTop = true }
            },
            icon = {
                Icon(
                    painterResource(R.drawable.bookmark),
                    contentDescription = "Избранное",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Избранное",
                    fontSize = 16.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.SemiBold
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = CustomGreen,
                unselectedIconColor = Color.White,
                selectedTextColor = CustomGreen,
                unselectedTextColor = Color.White,
                indicatorColor = CustomGray
            )
        )
        NavigationBarItem(
            selected = selectedItem == 2,
            onClick = {
                onItemClick(2)
                navController.navigate ("account") {
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(
                    painterResource(R.drawable.person),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {
                Text(
                    text = "Аккаунт",
                    fontSize = 16.sp,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.SemiBold
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = CustomGreen,
                unselectedIconColor = Color.White,
                selectedTextColor = CustomGreen,
                unselectedTextColor = Color.White,
                indicatorColor = CustomGray
            )
        )
    }
}