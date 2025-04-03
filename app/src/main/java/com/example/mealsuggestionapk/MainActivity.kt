package com.example.mealsuggestionapk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mealsuggestionapk.ui.theme.MealSuggestionAPKTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var meal_mname by remember {
                mutableStateOf("")
            }

            var meal_of_the_day by remember{
                mutableStateOf("")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Meal advisor",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black
                )

                Divider()
                Spacer(modifier = Modifier.size(30.dp))
                Text(
                    text = "Welcome to Meal advisor app",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                )

                OutlinedTextField(
                    value = meal_mname,
                    onValueChange = { text ->
                        meal_mname = text
                    },
                    placeholder = {
                        Text(
                            text = "Enter time of the day",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                )
                Spacer(modifier = Modifier.size(30.dp))
                Row {
                    Button(onClick = {
                        meal_of_the_day = when (meal_mname) {
                            "Morning breakfast" -> "Bacon and Eggs"
                            "Mid Morning snack" -> "Yoghurt with granola&honey"

                            "Afternoon lunch" -> "Mac&cheese with COCA COLA"
                            "Mid Afternoon" -> "Caramel Cake"

                            "Dinner" -> "Roast chicken with Mashed Potato"
                            "After dinner" -> "Ice cream"
                            else -> "Invalid meal name"
                        }
                    }) {
                        Text(text = "Recommend")
                    }
                    Button(onClick = {
                        meal_mname = ""
                        meal_of_the_day = ""

                    }) {
                        Text(text = "Reset")
                    }
                }

                Text(text = "Your meal today for $meal_mname is")
                Text(text = meal_of_the_day)
        }
    }
}}

