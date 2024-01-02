package com.example.jetpackcompose.ui.bottom

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.ui.screen.history.HistoryScreen
import com.example.jetpackcompose.ui.screen.home.HomeScreen
import com.example.jetpackcompose.ui.bottom.items.NavigationItem
import com.example.jetpackcompose.ui.screen.dashboard.DashboardScreen
import com.example.jetpackcompose.ui.screen.profile.ProfileScreen


@Composable
fun Navigations(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
//            HomeScreen()
            DashboardScreen()
        }
        composable(NavigationItem.History.route) {
            HistoryScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen()
        }
    }

}

@Composable
fun BottomNavigationbar(navController: NavHostController) {
    val items = listOf (
        NavigationItem.Home,
        NavigationItem.History,
        NavigationItem.Profile
    )
    var selectedItem by remember {
        mutableStateOf(0)
    }

    var currentRoute by remember {
        mutableStateOf(NavigationItem.Home.route)
    }

    items.forEachIndexed { index, navigationItem ->
        if (navigationItem.route == currentRoute) {
            selectedItem = index
        }
    }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                alwaysShowLabel = true,
                selected = selectedItem == index ,
                label = { Text(item.title) } ,
                icon = { Icon(item.icon!!, contentDescription = item.title) },
                onClick = {
                    selectedItem = index
                    currentRoute = item.route
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { it ->
                            popUpTo(it) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}