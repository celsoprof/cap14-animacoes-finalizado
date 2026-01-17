package br.com.fiap.animationtest.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentTest(navController: NavHostController) {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { count-- }) { Text("-") }

            // O AnimatedContent observa a variável count
            AnimatedContent(
                targetState = count,
                transitionSpec = {
                    // Se o novo número for maior, desliza para cima. Se menor, para baixo.
                    if (targetState > initialState) {
                        (slideInVertically { height -> height } + fadeIn()).togetherWith(
                            slideOutVertically { height -> -height } + fadeOut())
                    } else {
                        (slideInVertically { height -> -height } + fadeIn()).togetherWith(
                            slideOutVertically { height -> height } + fadeOut())
                    }.using(
                        // Mantém o tamanho do container sem "pular" durante a troca
                        SizeTransform(clip = false)
                    )
                }
            ) { targetCount ->
                Text(
                    text = "$targetCount",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
            }
            Button(onClick = { count++ }) { Text("+") }
        }
        Spacer(modifier = Modifier.height(28.dp))
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