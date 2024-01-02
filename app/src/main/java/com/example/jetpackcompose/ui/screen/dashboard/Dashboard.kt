package com.example.jetpackcompose.ui.screen.dashboard

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcompose.ui.screen.home.HomeViewModel

@Composable
fun DashboardScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
}