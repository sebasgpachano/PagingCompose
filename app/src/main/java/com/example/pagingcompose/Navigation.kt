package com.example.pagingcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pagingcompose.presentation.characters.CharacterScreen
import com.example.pagingcompose.presentation.details.DetailsScreen

@Composable
fun NavGraph(startDestination: String = "character_list") {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable("character_list") {
            CharacterScreen(navController = navController)
        }
        composable(
            "details/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.StringType })
        ) { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")
            DetailsScreen(characterId = characterId)
        }
    }
}