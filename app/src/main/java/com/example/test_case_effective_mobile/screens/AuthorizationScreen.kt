package com.example.test_case_effective_mobile.screens

import android.R.attr.password
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.test_case_effective_mobile.R
import com.example.test_case_effective_mobile.design.CustomTextField
import com.example.test_case_effective_mobile.ui.theme.CustomDividerColor
import com.example.test_case_effective_mobile.ui.theme.CustomGreen
import com.example.test_case_effective_mobile.ui.theme.CustomOKButtonColor1
import com.example.test_case_effective_mobile.ui.theme.CustomOKButtonColor2
import com.example.test_case_effective_mobile.ui.theme.CustomVKButtonColor
import com.example.test_case_effective_mobile.ui.theme.Roboto

@Composable
fun AuthorizationScreen(
    modifier: Modifier,
    navController: NavHostController
) {
    val context = LocalContext.current
    val emailState = remember { TextFieldState() }
    val passwordState = remember { TextFieldState() }
    fun isValidEmail(email: String): Boolean {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        return email.matches(regex)
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 100.dp)
                    .align(Alignment.Start),
                text = "Вход",
                fontSize = 28.sp,
                color = Color.White,
                fontFamily = Roboto,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.height(28.dp))
            Text(
                modifier = Modifier.align(Alignment.Start),
                text = "Email",
                fontSize = 16.sp,
                color = Color.White,
                fontFamily = Roboto,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(emailState, "example@gmail.com")
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.align(Alignment.Start),
                text = "Пароль",
                fontSize = 16.sp,
                color = Color.White,
                fontFamily = Roboto,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(passwordState, "Введите пароль")
            Spacer(modifier = Modifier.height(14.dp))
            Button(
                onClick = {
                    val email = emailState.text.trim()
                    val password = passwordState.text.trim()
                    if (email.isEmpty() || password.isEmpty()) {
                        println("Заполните все поля")
                        return@Button
                    }

                    if (!isValidEmail(email as String)) {
                        println("Некорректный email")
                        return@Button
                    }
                    navController.navigate("home")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = CustomGreen
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Вход",
                    color = Color.White,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(

            ) {
                Text(
                    text = "Нет аккаунта?",
                    fontSize = 12.sp,
                    color = Color.White,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    modifier = Modifier.clickable {

                    },
                    text = " Регистрация",
                    fontSize = 12.sp,
                    color = CustomGreen,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(
                modifier = Modifier.clickable {

                },
                text = "Забыл пароль",
                fontSize = 12.sp,
                color = CustomGreen,
                fontFamily = Roboto,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(32.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = CustomDividerColor
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/"))
                        context.startActivity(intent)
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = CustomVKButtonColor
                    ),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.vk_logo),
                        contentDescription = "VK logo",
                        tint = Color.White,
                        modifier = Modifier
                            .width(26.dp)
                            .height(16.dp)
                    )
                }
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ok.ru/"))
                        context.startActivity(intent)
                    },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    contentPadding = PaddingValues()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(40.dp)
                            .background(
                                shape = RoundedCornerShape(12.dp),
                                brush = Brush.verticalGradient(
                                    colors = listOf(CustomOKButtonColor1, CustomOKButtonColor2)
                                )
                            )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ok_logo),
                            contentDescription = "OK logo",
                            tint = Color.White,
                            modifier = Modifier
                                .width(15.29.dp)
                                .height(26.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}