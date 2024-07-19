package com.example.whatsapclone.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController


//Redefining the properties of color
private val DarkColorScheme = darkColorScheme(
    primary = Grey,
    secondary = LightGrey,
    tertiary = White,
    background = LightGrey
)
private val LightColorScheme = lightColorScheme(
    primary = Green,
    secondary = LightGreen,
    tertiary = Black,
    background = White

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun WhatsApCloneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    //dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    // 7 Add customize colors to your application
    val colorScheme = if(darkTheme)
        DarkColorScheme
    else
        LightColorScheme

    //The LocalView contains the current Compose view
    val view = LocalView.current
    if (!view.isInEditMode) {
            val systemUiController = rememberSystemUiController()

            val statusBarColor = if(darkTheme)
                Grey
            else
                Green

            val navigationBar = if(isSystemInDarkTheme())
                LightGrey
            else
                White

//Schedule effect to run when the current composition completes successfully and applies changes
        SideEffect {
            systemUiController.setStatusBarColor(
                statusBarColor
            )
            systemUiController.setNavigationBarColor(
                navigationBar
            )
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}


