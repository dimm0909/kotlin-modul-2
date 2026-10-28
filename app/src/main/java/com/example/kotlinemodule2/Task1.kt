package com.example.kotlinemodule2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Hello(
    name: String?,
    modifier: Modifier = Modifier
) {
    val textToDisplay = if (name.isNull_or_blank()) {
        "Имя не задано"
    } else {
        "Привет, $name!"
    }

    Text(
        text = textToDisplay,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        modifier = modifier
    )
}

private fun String?.isNull_or_blank(): Boolean {
    return this == null || this.isBlank()
}

@Composable
fun Task1Screen(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Задание 1: Приветственная надпись",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Hello(name = "Алексей")
            Spacer(modifier = Modifier.height(8.dp))
            Hello(name = null)
        }
    }
}

@Preview(showBackground = true, name = "Hello With Name")
@Composable
fun HelloWithNamePreview() {
    Hello(name = "Алексей")
}

@Preview(showBackground = true, name = "Hello With Null")
@Composable
fun HelloWithNullPreview() {
    Hello(name = null)
}
