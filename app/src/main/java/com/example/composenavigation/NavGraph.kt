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
            route = Screen.Second.route + "?name={name}" + "?age={age}",
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
                defaultValue = "params is empty"
                nullable = true
            },
                navArgument("age") {
                    type = NavType.StringType
                    defaultValue = "empty"
                    nullable = true
                }
            )
        ) {
            SecondScreen(
                navController = navController,
                name = it.arguments?.getString("name").toString(),
                age = it.arguments?.getString("age").toString()
            )
        }
    }
}