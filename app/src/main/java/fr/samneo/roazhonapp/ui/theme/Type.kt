package fr.samneo.roazhonapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import fr.samneo.roazhonapp.R

val AlumniSansCollegiate = FontFamily(
    Font(R.font.alumni_sans_collegiate_one_regular), Font(R.font.alumni_sans_collegiate_one_italic)
)
val BebasNeue = FontFamily(
    Font(R.font.bebas_neue_regular)
)
val PlayPenSans = FontFamily(
    Font(R.font.playpen_sans_regular), Font(R.font.alumni_sans_collegiate_one_italic)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyMedium = TextStyle( // Description text on DetailWindow
        fontFamily = PlayPenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ), displayLarge = TextStyle( // Text on RecommendationWindow
        fontFamily = AlumniSansCollegiate,
        fontWeight = FontWeight.Normal,
        fontSize = 52.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.5.sp
    ), displayMedium = TextStyle( // Text on CategoryWindow
        fontFamily = AlumniSansCollegiate,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp,
        fontStyle = FontStyle.Italic
    ), titleMedium = TextStyle( // Text on AppTopBar
        fontFamily = BebasNeue,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    )
)