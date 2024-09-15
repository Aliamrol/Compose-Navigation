package com.example.composenavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Second.route + "/{person}",
            arguments = listOf(navArgument("person") {
                type = NavType.StringType
            }
            )
        ) {
            SecondScreen(
                navController = navController,
                person = it.arguments?.getString("person").toString()
            )
        }
    }
}