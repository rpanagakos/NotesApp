package com.example.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.notesapp.presentation.screens.auth.AuthenticationScreen
import com.example.notesapp.util.Constants.WRITE_SCREEN_ARGUMENT_KEY
import com.stevdzasan.onetap.rememberOneTapSignInState

@Composable
fun SetUpNavGraph(startDestination: String, navController: NavHostController) {
    NavHost(navController = navController, startDestination = startDestination) {
        authenticationRoute()
        homeRoute()
        writeRoute()
    }
}


fun NavGraphBuilder.authenticationRoute() {
    composable(route = Screen.Authentication.route) {
        val oneTapState = rememberOneTapSignInState()
        AuthenticationScreen(
            loadingState = oneTapState.opened,
            oneTapSignInState = oneTapState,
            onButtonClicked = { oneTapState.open() })
    }
}

fun NavGraphBuilder.homeRoute() {
    composable(route = Screen.Home.route) {

    }
}

fun NavGraphBuilder.writeRoute() {
    composable(
        route = Screen.Write.route,
        arguments = listOf(navArgument(name = WRITE_SCREEN_ARGUMENT_KEY) {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {

    }
}