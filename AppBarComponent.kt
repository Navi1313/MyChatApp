package com.example.whatsapclone.ui.Component

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import android.provider.MediaStore
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.whatsapclone.R
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
@SuppressLint("QueryPermissionsNeeded")
@Composable
fun AppBarComponent (navController: NavController,
                     packageManager: PackageManager,
                     context: Context
){

    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { /* Handle the camera result here */ }
    )
   Row(modifier = Modifier
       .fillMaxWidth()
       .height(60.dp)
       .background(MaterialTheme.colorScheme.primary)
       .padding(15.dp),
       verticalAlignment = Alignment.CenterVertically
        ) {

        Text(text = "My Chat",
            style = TextStyle(
                fontSize = 23.sp ,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.tertiary
            )
        )
       // Calling an Camera , search and three dots
       Spacer(modifier = Modifier.weight(0.9f))

       Image(painter = painterResource(id = R.drawable.ic_camera),
           contentDescription = "camera", modifier = Modifier
               .clickable {

// Check if there is a camera activity available
                   if (cameraIntent.resolveActivity(packageManager) != null) {
                       // If a camera activity is available, launch the intent
                       launcher.launch(cameraIntent)
                   } else {
                       // If no camera activity is available, show an error message
                       Toast.makeText(context, "No camera app available", Toast.LENGTH_SHORT).show()
                   }
               })

       Spacer(modifier = Modifier.size(20.dp))
       Image(painter = painterResource(id = R.drawable.ic_search),
           contentDescription = "camera", modifier = Modifier
               .clickable {
                   navController.navigate("camera_screen")
               })
       Spacer(modifier = Modifier.size(20.dp))
       Image(painter = painterResource(id = R.drawable.threedots),
           contentDescription = "camera", modifier = Modifier
               .clickable {
                   navController.navigate("camera_screen")
               }

           )
    }
}
@Composable
fun IconImage(drawable :Int){
    Icon(painter = painterResource(id = drawable ) ,
        contentDescription = "",
        tint = MaterialTheme.colorScheme.tertiary
    )
}

//@Preview(showBackground = true)
//@Composable
//fun AppBarComponentPrev(){
//    AppBarComponent"NavController")
//}

