package com.example.jetpackcompose.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackcompose.ui.bottom.BottomNavigationbar
import com.example.jetpackcompose.ui.bottom.Navigations
import com.example.jetpackcompose.ui.screen.home.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel
) {
    Scaffold (
        bottomBar = {
            BottomAppBar (modifier = Modifier) {
                BottomNavigationbar(navController = navController)
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(
                PaddingValues(
                    0.dp,
                    0.dp,
                    0.dp,
                    innerPadding.calculateBottomPadding()
                )
            )
        ) {
            Navigations(navController = navController, homeViewModel)
        }
    }
}

