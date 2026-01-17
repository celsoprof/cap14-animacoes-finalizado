package br.com.fiap.animationtest.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(48.dp)
    ) {
        Text(
            text = "Animações com Jetpack Compose",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = {
                navController.navigate("animate-content-size")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Animated Content Size"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("animated-visibility")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Animated Visibility"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("crossfade")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Crossfade"
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("animated-content")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Animated Content"
            )
        }
    }
}