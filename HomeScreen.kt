package com.example.whatsapclone.ui.Screens

import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.whatsapclone.INITIAL_SCREEN_INDEX
import com.example.whatsapclone.ui.Component.AppBarComponent
import com.example.whatsapclone.ui.Component.TabsComponents
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController,
               packageManager: PackageManager = LocalContext.current.packageManager,
               context: Context = LocalContext.current,) {

    val pagerState = rememberPagerState {
        INITIAL_SCREEN_INDEX
    }
    val scope = rememberCoroutineScope()

    Column {
        AppBarComponent( navController = navController,
            packageManager = packageManager,
            context = context)
        TabsComponents(
            navController ,
            InitialIndex = INITIAL_SCREEN_INDEX,
            pagerState = pagerState

        ) { selectedPage ->
            scope.launch{
                pagerState.animateScrollToPage(selectedPage as Int)
            }
        }
        HorizontalPager(modifier = Modifier.
                        fillMaxWidth(),
                state = pagerState
            ) {
                page ->
                when(page){
                0 -> ChatScreen(navController)
                1 -> StatusScreen(navController)
                2 -> CallsScreen(navController)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPrev(){
//    HomeScreen(navController)
//}