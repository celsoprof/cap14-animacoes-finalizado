package br.com.fiap.animationtest.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun CrossfadeTest(navController: NavHostController) {
    // Estado que define qual "cena" mostrar
    var isPlaying by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // O Crossfade observa a variável isPlaying
        Crossfade(
            targetState = isPlaying,
            animationSpec = tween(500)) {
            when (it) {
                false -> {
                    IconButton(
                        onClick = { isPlaying = true }) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play",
                            modifier = Modifier.size(64.dp),
                            tint = Color.Blue
                        )
                    }
                }
                true -> {
                    IconButton(
                        onClick = { isPlaying = false }) {
                        Icon(
                            imageVector = Icons.Default.Close, // Ou um ícone de Pause
                            contentDescription = "Pause",
                            modifier = Modifier.size(64.dp),
                            tint = Color.Red
                        )
                    }
                }
            }
        }
        Text(text = if (isPlaying) "Reproduzindo..." else "Pausado")
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Voltar ao menu"
            )
        }
    }
}