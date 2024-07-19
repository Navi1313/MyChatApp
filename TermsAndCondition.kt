package com.example.whatsapclone.ui.Screens

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.example.whatsapclone.DestinationScreen
import java.lang.reflect.Modifier

@Composable
fun TermsAndCondition(navController: NavController ) {

    Text(text = "Kaccha mango byte Abhi naya app hai thora w8 . in progress ",
        style = TextStyle(
            fontSize = 40.sp,

        )
    )
}