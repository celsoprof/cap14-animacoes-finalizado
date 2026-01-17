package br.com.fiap.animationtest.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
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
fun AnimatedVisibilityTest(navController: NavHostController) {
    var isVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(if (isVisible) "Ocultar Mensagem" else "Mostrar Mensagem")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // O AnimatedVisibility envolve o conteúdo que deve ser animado
        AnimatedVisibility(
            visible = isVisible,
            // Personalizando a entrada: Desliza de cima + FadeIn
            enter = slideInVertically() + fadeIn(),
            // Personalizando a saída: Encolhe + FadeOut
            exit = shrinkVertically() + fadeOut()
        ) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFDFF2BF), // Verde claro de sucesso
                shape = RoundedCornerShape(8.dp),
                tonalElevation = 0.dp
            ) {
                Text(
                    text = "Operação realizada com sucesso!",
                    modifier = Modifier.padding(16.dp),
                    color = Color(0xFF4F8A10)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
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