package com.example.kotlinemodule2

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Task3Variant1(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.compose_description),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun Task3Variant2(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.compose_description),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier
    )
}

@Composable
fun Task3Variant3(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.compose_description),
        color = Color.Black,
        fontSize = 24.sp,
        style = TextStyle(
            textDecoration = TextDecoration.Underline,
            textIndent = TextIndent(firstLine = 48.sp)
        ),
        modifier = modifier.background(Color.Green)
    )
}

@Composable
fun Task3Screen(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Задание 3: Варианты отображения текста",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Вариант 1 (зелёный, 16sp, курсив, по центру):", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Task3Variant1(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Вариант 2 (одна строка с многоточием):", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Task3Variant2(modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Вариант 3 (отступ 48sp, 24sp, чёрный текст, зелёный фон, подчёркнутый):", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            Task3Variant3(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview(showBackground = true, name = "Task 3 - Variant 1")
@Composable
fun Task3Variant1Preview() {
    Task3Variant1()
}

@Preview(showBackground = true, name = "Task 3 - Variant 2")
@Composable
fun Task3Variant2Preview() {
    Task3Variant2()
}

@Preview(showBackground = true, name = "Task 3 - Variant 3")
@Composable
fun Task3Variant3Preview() {
    Task3Variant3()
}
