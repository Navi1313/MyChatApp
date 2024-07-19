package com.example.whatsapclone

data class TabData (
    val title : String,
    val unreadCount : Int?
)

val tab = listOf(
    TabData(title = Tabs.CHAT.value ,unreadCount = 5),
    TabData(title = Tabs.STATUS.value, unreadCount = 900),
    TabData(title = Tabs.CALLS.value, unreadCount = 10)
)

enum class Tabs(val value: String) {

    CHAT("Chats"),
    STATUS("Status"),
    CALLS("Calls")
}
const val INITIAL_SCREEN_INDEX = 0