package com.example.basketlyfe.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.basketlyfe.R

val Prompt = FontFamily(
    Font(R.font.prompt_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.prompt_blackitalic, FontWeight.Black, FontStyle.Italic),

    Font(R.font.prompt_extrabold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.prompt_extrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),

    Font(R.font.prompt_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.prompt_bolditalic, FontWeight.Bold, FontStyle.Italic),

    Font(R.font.prompt_semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.prompt_semibolditalic, FontWeight.SemiBold, FontStyle.Italic),

    Font(R.font.prompt_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.prompt_mediumitalic, FontWeight.Medium, FontStyle.Italic),

    Font(R.font.prompt_regular, FontWeight.Normal, FontStyle.Normal),

    Font(R.font.prompt_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.prompt_lightitalic, FontWeight.Light, FontStyle.Italic),

    Font(R.font.prompt_extralight, FontWeight.ExtraLight, FontStyle.Normal),
    Font(R.font.prompt_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),

    Font(R.font.prompt_thin, FontWeight.Thin, FontStyle.Normal),
    Font(R.font.prompt_thinitalic, FontWeight.Thin, FontStyle.Italic),
)



// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)