package com.example.kotlinemodule2

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

/**
 * Задание 10:
 * Исправление ошибок рекомпозиции и состояния в корзине покупок.
 */

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    val totalSum by remember {
        derivedStateOf { products.sumOf { it.price } }
    }

    val context = LocalContext.current
    var hasShownToast by remember { mutableStateOf(false) }

    LaunchedEffect(totalSum) {
        if (totalSum > 500 && !hasShownToast) {
            Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
            hasShownToast = true
        } else if (totalSum <= 500) {
            hasShownToast = false
        }
    }

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Корзина товаров",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        for (product in products) {
            Text(text = "${product.name} - ${product.price} рублей")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Товаров на сумму: $totalSum рублей",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))

        AddProductSection(
            onAdd = {
                val nextIndex = products.size + 1
                products = products + Product(
                    id = products.size,
                    name = "Товар #$nextIndex",
                    price = Random.nextInt(50, 200)
                )
            }
        )

        if (products.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            RemoveProductSection(
                onRemove = {
                    if (products.isNotEmpty()) {
                        products = products.dropLast(1)
                    }
                }
            )
        }
    }
}

@Composable
fun AddProductSection(onAdd: () -> Unit) {
    Button(onClick = onAdd) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(onRemove: () -> Unit) {
    OutlinedButton(onClick = onRemove) {
        Text(text = "Удалить товар")
    }
}

@Composable
fun Task10Screen(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        ShoppingCartScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartScreenPreview() {
    ShoppingCartScreen()
}
