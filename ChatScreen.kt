package com.example.whatsapclone.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ChatScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Chat Screen Screen", style = TextStyle(
            fontSize = 30.sp))

    }
}

//@Preview(showBackground = true)
//@Composable
//fun ChatScreenPrev(){
//    StatusScreen(navController)
//}