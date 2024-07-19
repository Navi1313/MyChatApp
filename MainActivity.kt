package com.example.whatsapclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.whatsapclone.ui.Component.AppBarComponent
import com.example.whatsapclone.ui.Screens.HomeScreen
import com.example.whatsapclone.ui.Screens.LoginScreen
import com.example.whatsapclone.ui.Screens.SignUpScreen
import com.example.whatsapclone.ui.theme.WhatsApCloneTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

// creating an Sealed classes to restrict the inheritance hierarchy of its subClass
sealed class DestinationScreen (var Route : String){


    object SignUp : DestinationScreen("signUp")
    object Login : DestinationScreen("login")
    object Profile : DestinationScreen("profile")
    object ChatScreen : DestinationScreen("chatScreen")
    object StatusScreen : DestinationScreen("")
    object TermsandCondition : DestinationScreen("tc")
    object HomeScreen : DestinationScreen("hs")
    object CallScreen : DestinationScreen("call_screen")


    object singleChatScreen : DestinationScreen("singleChatScreen/{chatId}"){
        fun CreateRoute(id:  String) = "singleChatScreen/$id"
    }

    object singleStatusScreen : DestinationScreen("singleStatusScreen/{statusId}"){
        fun CreateRoute(UserId : String) = "singleStatusScreen/$UserId"
    }
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            WhatsApCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavBwScreens()
                }
            }
        }
    }
}

