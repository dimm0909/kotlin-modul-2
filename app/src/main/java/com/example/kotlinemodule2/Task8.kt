package com.example.kotlinemodule2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Задание 8:
 * Исправление и расширение функции WaterTracker (Трекер воды):
 * - Кнопка добавления жидкости (+250 мл).
 * - Кнопка «Завершить день».
 * - Подсчёт и вывод количества дней подряд с нормой 1500+ мл.
 */

val primaryColor = Color(0xFF415F91)
val secondaryColor = Color(0xFF565F71)

@Composable
fun WaterTracker(modifier: Modifier = Modifier) {
    var waterCount by remember { mutableIntStateOf(0) }
    var streakDays by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor,
            modifier = Modifier.testTag("water_tracker_title")
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor,
            modifier = Modifier.testTag("water_count_text")
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            onClick = { waterCount += 250 },
            modifier = Modifier.testTag("add_water_button")
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedButton(
            onClick = {
                if (waterCount >= 1500) {
                    streakDays += 1
                } else {
                    streakDays = 0
                }
                waterCount = 0
            },
            modifier = Modifier.testTag("complete_day_button")
        ) {
            Text(
                text = "Завершить день",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Дней с нормой 1500+ мл подряд: $streakDays",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = secondaryColor,
            modifier = Modifier.testTag("streak_days_text")
        )
    }
}

@Composable
fun Task8Screen(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        WaterTracker()
    }
}

@Preview(showBackground = true)
@Composable
fun WaterTrackerPreview() {
    WaterTracker()
}
