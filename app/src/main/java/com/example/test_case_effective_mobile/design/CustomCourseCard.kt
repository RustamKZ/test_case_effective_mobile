package com.example.test_case_effective_mobile.design

import android.R.attr.contentDescription
import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_case_effective_mobile.R
import com.example.test_case_effective_mobile.api.Course
import com.example.test_case_effective_mobile.ui.theme.CustomBlackCardColor
import com.example.test_case_effective_mobile.ui.theme.CustomBlackColor
import com.example.test_case_effective_mobile.ui.theme.CustomGray
import com.example.test_case_effective_mobile.ui.theme.CustomGreen
import com.example.test_case_effective_mobile.ui.theme.Roboto

@Composable
fun CustomCourseCard(
    course: Course,
    isLike: Boolean = false,
    onLikeClick: (Course) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(236.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(CustomBlackCardColor)
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(114.dp)
                    .clip(RoundedCornerShape(16.dp)),
        ) {
            Image(
                painter = painterResource(id = R.drawable.cover_1),
                contentDescription = "Cover 1",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(16.dp))
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp, end = 8.dp)
                    .size(28.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        onLikeClick(course)
                    }
                    .align(Alignment.TopEnd),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(CustomBlackColor.copy(alpha = 0.3f))
                        .blur(16.dp)
                )
                Icon(
                    painter = if (course.hasLike || isLike) painterResource(R.drawable.bookmark_filled) else painterResource(R.drawable.bookmark),
                    contentDescription = "Filter",
                    tint = if (course.hasLike || isLike) CustomGreen else Color.White,
                    modifier = Modifier
                        .width(10.67.dp)
                        .height(13.33.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 8.dp)
                    .align(Alignment.BottomStart),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(CustomBlackColor.copy(alpha = 0.3f))
                            .blur(16.dp)
                    )
                    Row(
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.star_fill),
                            contentDescription = "Star",
                            tint = CustomGreen,
                            modifier = Modifier.size(12.dp)
                        )
                        Text(
                            course.rate,
                            fontSize = 12.sp,
                            color = Color.White,
                            fontFamily = Roboto,
                            fontWeight = FontWeight.Normal,
                            lineHeight = 14.sp
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(CustomBlackColor.copy(alpha = 0.3f))
                            .blur(16.dp)
                    )
                    Box(
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            course.publishDate,
                            fontSize = 12.sp,
                            color = Color.White,
                            fontFamily = Roboto,
                            fontWeight = FontWeight.Normal,
                            lineHeight = 14.sp
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier.padding(start = 16.dp,end = 16.dp, top = 130.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                course.title,
                fontSize = 16.sp,
                color = Color.White,
                fontFamily = Roboto,
                fontWeight = FontWeight.Medium,
                lineHeight = 18.sp
            )
            Text(
                course.text,
                fontSize = 12.sp,
                color = Color.White,
                fontFamily = Roboto,
                fontWeight = FontWeight.Normal,
                lineHeight = 16.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.alpha(0.7f)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    course.price,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontFamily = Roboto,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 18.sp
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Подробнее",
                        fontSize = 12.sp,
                        color = CustomGreen,
                        fontFamily = Roboto,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 15.sp
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_right),
                        contentDescription = "arrow_right",
                        tint = CustomGreen,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}