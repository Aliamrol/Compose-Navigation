package com.example.composenavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "My home screen")
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            val person = Person(
                name = "Ali",
                family = "Amrol",
                age = 20,
                phone = "09057510010"
            )
            val gson = Gson()
            val personAsString = gson.toJson(person)
            navController.navigate(Screen.Second.withArgs(personAsString))
        }) {
            Text("Go To Second Screen")
        }
    }
}