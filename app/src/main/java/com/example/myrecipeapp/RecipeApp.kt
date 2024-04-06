package com.example.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(
    navController: NavHostController
) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categorieState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route){
        composable(route = Screen.RecipeScreen.route){
            RecipeScreen(viewState = viewState,navigateToDetail = {
                //Essa parte é responsável por passar as informações da tela atual para a Detail Screen
                //Que utiliza o savedStateHandle, que é um componente do Compose Navigation Framework.

                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screen.DetailScreen.route)
            })
        }
        composable(route = Screen.DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.
            get<Category>("cat") ?: Category("","","","")

            CategoryDetailScreen(category = category)
        }
    }
}