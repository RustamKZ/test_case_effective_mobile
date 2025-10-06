package com.example.test_case_effective_mobile.design

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_case_effective_mobile.ui.theme.CustomGray
import com.example.test_case_effective_mobile.ui.theme.Roboto

@Composable
fun CustomTextField(
    state: TextFieldState,
    textLabel: String = ""
) {
    BasicTextField(
        state = state,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(CustomGray, shape = RoundedCornerShape(30.dp))
            .padding(horizontal = 16.dp)
        ,
        textStyle = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            fontSize = 14.sp,
            lineHeight = 18.sp
        ),
        lineLimits = TextFieldLineLimits.SingleLine,
        cursorBrush = SolidColor(Color.White),
        decorator = {
            innerTextField ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                if (state.text.isEmpty()) {
                    Text(
                        text = textLabel,
                        color = Color.White,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        modifier = Modifier.alpha(0.5f)
                    )
                }
                innerTextField()
            }
        }
    )
}