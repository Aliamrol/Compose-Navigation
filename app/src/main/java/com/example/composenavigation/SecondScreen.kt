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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson


@Composable
fun SecondScreen(
    navController: NavController,
    person: String,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val gson = Gson()
        val myPerson = gson.fromJson(person, Person::class.java)
        Text(
            text = "name : ${myPerson.name} , family:${myPerson.family} , age: ${myPerson.age} , phone: ${myPerson.phone}",
            color = Color.Magenta
        )
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {

            /*can use this too
            navController.popBackStack()
           */
            navController.navigate(route = Screen.Home.route) {
                popUpTo(Screen.Home.route) {
                    inclusive = true
                }
            }
        }) {
            Text("Go To Home Screen")
        }
    }
}