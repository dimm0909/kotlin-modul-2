package com.example.kotlinemodule2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Задание 6:
 * 1) Расположите круг исходного размера в правом верхнем углу в компоненте c чёрным фоном, размер — 240.dp x 120.dp.
 * 2) Задайте синий цвет фона компонента. Расположите круг по центру и растяните по размерам.
 *    Используйте цвет фиолетовый (ColorFilter.tint).
 */

@Composable
fun Task6aCircleInCorner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black),
        contentAlignment = Alignment.TopEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Circle",
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun Task6bCircleStretchedPurple(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Stretched Circle",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF800080)) // фиолетовый цвет
        )
    }
}

@Composable
fun Task6Screen(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Задание 6: Расположение элементов и ColorFilter",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "1) Круг в правом верхнем углу (240x120, чёрный фон):", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Task6aCircleInCorner()

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "2) Растянутый фиолетовый круг (синий фон):", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Task6bCircleStretchedPurple()
        }
    }
}

@Preview(showBackground = true, name = "Task 6a - Corner")
@Composable
fun Task6aPreview() {
    Task6aCircleInCorner()
}

@Preview(showBackground = true, name = "Task 6b - Stretched Purple")
@Composable
fun Task6bPreview() {
    Task6bCircleStretchedPurple()
}
