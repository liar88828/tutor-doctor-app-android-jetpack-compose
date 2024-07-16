package com.doctorapp.doc_app.persentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.doctorapp.doc_app.navigation.screen.BottomNavigationScreen
import com.doctorapp.doc_app.ui.theme.BluePrimary
import com.doctorapp.doc_app.ui.theme.PurpleGrey
import com.doctorapp.doc_app.ui.theme.poppinsFontFamily

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
	var navigationSelectedItem by remember { mutableIntStateOf(0) }
	val bottomNavigationItem = listOf(
		BottomNavigationScreen.Home,
		BottomNavigationScreen.Schedule,
		BottomNavigationScreen.Chat,
		BottomNavigationScreen.Profile,
	)
	val navController = rememberNavController()

	Scaffold(modifier = modifier.fillMaxSize(), bottomBar = {
		NavigationBar(
			containerColor = Color.White, tonalElevation = 8.dp
		) {
			bottomNavigationItem.forEachIndexed { index, item ->
				NavigationBarItem(
					colors = NavigationBarItemDefaults.colors(
						selectedIconColor = BluePrimary,
						selectedTextColor = BluePrimary,
						unselectedIconColor = PurpleGrey,
						unselectedTextColor = PurpleGrey
					),
					selected = index == navigationSelectedItem,
					icon = {
						Icon(
							painter = painterResource(id = item.icon),
							contentDescription = item.title
						)
					},
					label = {
						Text(
							text = item.title,
							fontFamily = poppinsFontFamily,
							fontWeight = FontWeight.Medium,
							color = Color(0xFF3CB1FF)
						)
					},
					alwaysShowLabel = index == navigationSelectedItem,
					onClick = {
						navigationSelectedItem = index
						navController.navigate(item.route) {
							popUpTo(navController.graph.startDestinationId) {
								saveState = true
							}
							launchSingleTop = true
							restoreState = true
						}
					},
				)
			}
		}
	}) { innerPadding ->
		NavHost(
			modifier = modifier.padding(paddingValues = innerPadding),
			navController = navController,
			startDestination = BottomNavigationScreen.Home.route,
		) {
			composable(route = BottomNavigationScreen.Home.route) { HomeScreen() }
			composable(route = BottomNavigationScreen.Schedule.route) { ScheduleScreen() }
			composable(route = BottomNavigationScreen.Chat.route) { HomeScreen() }
			composable(route = BottomNavigationScreen.Profile.route) { ScheduleScreen() }
		}
	}

}

@Preview(
//showBackground = true,
// showSystemUi = true
)
@Composable
private fun MainScreenPrev() {
	MainScreen()

}