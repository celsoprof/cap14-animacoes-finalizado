package br.com.fiap.animationtest.ui.screens

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navegacao() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        // Animações padrão para todas as rotas deste NavHost
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            ) + fadeIn(animationSpec = tween(700))
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            ) + fadeOut(animationSpec = tween(700))
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        }
    ) {
        composable("home") { Home(navController) }
        composable("animate-content-size") { AnimateContentSizeTest(navController) }
        composable("animated-visibility") { AnimatedVisibilityTest(navController) }
        composable("animated-content") { AnimatedContentTest(navController) }
        composable("crossfade") { CrossfadeTest(navController) }
    }
}