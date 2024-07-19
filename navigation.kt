package com.example.whatsapclone

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.whatsapclone.ui.Screens.CallsScreen
import com.example.whatsapclone.ui.Screens.ChatScreen
import com.example.whatsapclone.ui.Screens.HomeScreen
import com.example.whatsapclone.ui.Screens.LoginScreen
import com.example.whatsapclone.ui.Screens.ProfileScreen
import com.example.whatsapclone.ui.Screens.SignUpScreen
import com.example.whatsapclone.ui.Screens.StatusScreen
import com.example.whatsapclone.ui.Screens.TermsAndCondition
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun NavBwScreens() {
   val navController = rememberNavController()

    // CREATING AN VIEW MODEL VARIABLE
    val vm = hiltViewModel<MCViewModel>()

    NavHost(navController = navController,
        startDestination = DestinationScreen.Login.Route) {

        composable(route = DestinationScreen.SignUp.Route) {
            SignUpScreen(navController, vm)

        }
        composable(route = DestinationScreen.Login.Route) {
            LoginScreen(navController)
        }

        composable(route = DestinationScreen.TermsandCondition.Route) {
            TermsAndCondition(navController)
        }

        composable(route = DestinationScreen.HomeScreen.Route){
            HomeScreen(navController)
        }

        composable(route = DestinationScreen.CallScreen.Route){
            CallsScreen(navController)
        }

        composable(route = DestinationScreen.ChatScreen.Route){
            ChatScreen(navController )

        }
//        composable(route = DestinationScreen.StatusScreen.Route){
//            StatusScreen(navController)
//        }
    }
}
