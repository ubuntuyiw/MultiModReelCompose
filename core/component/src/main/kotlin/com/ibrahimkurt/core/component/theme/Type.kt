package com.ibrahimkurt.core.component.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.ibrahimkurt.core.component.R

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.worksans_bold)),
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.montserrat_thin)),
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
)