package br.com.fiap.animationtest.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AnimateContentSizeTest(navController: NavHostController) {
    // Estado que controla se o card está expandido
    var expandido by remember { mutableStateOf(false) }

    // Animação da rotação do ícone (0 a 180 graus)
    val rotacao by animateFloatAsState(targetValue = if (expandido) 180f else 0f)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .safeContentPadding()
                //.padding(16.dp)
                .clickable { expandido = !expandido }
                .animateContentSize() // Anima o tamanho do card automaticamente
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Clique para ver detalhes",
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.rotate(rotacao) // Aplica a rotação animada
                    )
                }

                if (expandido) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Este é o conteúdo extra que aparece com uma animação suave de redimensionamento. " +
                                "O Jetpack Compose detecta a mudança de tamanho e aplica o animateContentSize."
                    )
                }

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