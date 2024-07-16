package com.doctorapp.doc_app.navigation.screen

import com.doctorapp.doc_app.R

sealed class BottomNavigationScreen(val route: String, val title: String, val icon: Int) {
	data object Home : BottomNavigationScreen(
		route = "home_screen",
		title = "Home",
		icon = R.drawable.ic_bottom_home
	)

		data object Schedule : BottomNavigationScreen(
		route = "schedule_screen",
		title = "Schedule",
		icon = R.drawable.ic_bottom_schedule
	)

	data object Chat : BottomNavigationScreen(
		route = "chat_screen",
		title = "Chat",
		icon = R.drawable.ic_bottom_chat
	)

	data object Profile : BottomNavigationScreen(
		route = "profile_screen",
		title = "Profile",
		icon = R.drawable.ic_bottom_profile
	)



}
