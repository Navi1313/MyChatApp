package com.example.whatsapclone.ui.Component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.whatsapclone.DestinationScreen
import com.example.whatsapclone.TabData
import com.example.whatsapclone.tab


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsComponents(
    navController: NavController,
    InitialIndex: Int = 0,
    pagerState: PagerState,
    onTabSelected: (Any) -> Unit
){
    var selectedIndex by remember {  mutableIntStateOf(0)  }

    TabRow(
// Properties of a tab row :
        selectedTabIndex = selectedIndex, // This attribute is for Index of currently selected tab
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.primary, // Color used for bg of this row
        contentColor = MaterialTheme.colorScheme.tertiary , //  text inside the container in row

// This is for changing color indicator of selected tab
        indicator = { tabPosition ->
            TabRowDefaults.Indicator(// Contains default implementations and values used for TabRow

                // Modifier that takes up all the available width inside the TabRow, and then animates
                // the offset of the indicator it is applied to, depending on the currentTabPosition
                modifier = Modifier.tabIndicatorOffset(tabPosition[selectedIndex]),
                color = MaterialTheme.colorScheme.tertiary,
                height = 2.dp
            )
        }
    ) {

// This lambda expression inside Tab is running for three times because we have three tab components:
        tab.forEachIndexed { idx ,tabData ->
            Tab(selected = idx == selectedIndex, // whether tab is selected or Not
                onClick = { selectedIndex = idx
                    onTabSelected(selectedIndex)},
                text = {
                    TabContent(tabData = tabData,navController)
                }
            )
        }
    }
}
//@OptIn(ExperimentalFoundationApi::class)
//@Preview
//@Composable
//fun TabsComponentsPreview() {
//    val pagerState = rememberPagerState(pageCount = { 1 })
//    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")
//
//    TabsComponents(
//        InitialIndex = 0,
//        pagerState = pagerState,
//        onTabSelected = { /* Handle tab selection */ },
//    )
//}
// Checking Weather the Unread Count == Null or not
@Composable
fun TabContent(tabData: TabData,navController: NavController){
    if(tabData.unreadCount ==null)
        TabTitle(title = tabData.title, navController)
    else
        UnreadCountVal(tabData = tabData, navController)
}

// Creating an Composable that giving an modified properties of tab bar :->
@Composable
fun TabTitle(title: String, navController: NavController){
        Text(text = title,
            modifier = Modifier.clickable {
             if(title == "Chat"){
                        navController.navigate(DestinationScreen.ChatScreen.Route)
             }
                else if(title == "Status"){
                 navController.navigate(DestinationScreen.StatusScreen.Route)
             }
                else{
                 navController.navigate(DestinationScreen.CallScreen.Route)
             }
            },
        style = TextStyle(fontSize = 16.sp)
        )
}


// Defining an Ui and Logic  for the Tab Unread Count
@Composable
fun UnreadCountVal(tabData: TabData, navController: NavController){

    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){
        
        TabTitle(title = tabData.title, navController )

        tabData.unreadCount?.also{ unreadCount ->
            Text(
                text = unreadCount.toString(),
                modifier = Modifier
                    .padding(4.dp)
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.background),
                style = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                fontSize = 12.sp
                )
            )
        }
    }
}
