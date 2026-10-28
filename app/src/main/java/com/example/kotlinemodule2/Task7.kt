package com.example.kotlinemodule2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class ContactInfo(
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val phone: String,
    val address: String
)

val sampleContact1 = ContactInfo(
    firstName = "Евгений",
    middleName = "Андреевич",
    lastName = "Лукашин",
    phone = "+7 495 495 95 95",
    address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
)

val sampleContact2 = ContactInfo(
    firstName = "Василий",
    middleName = "Егорович",
    lastName = "Кузякин",
    phone = "--",
    address = "Ивановская область, дер. Крутово, д. 4"
)

val sampleContact3 = ContactInfo(
    firstName = "Людмила",
    middleName = "Прокофьевна",
    lastName = "Калугина",
    phone = "+7 495 788 78 78",
    address = "г. Москва, Большая Никитская, д. 43, кв. 290"
)

@Composable
fun ContactColumn(contact: ContactInfo, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Имя: ${contact.firstName}")
        Text(text = "Отчество: ${contact.middleName}")
        Text(text = "Фамилия: ${contact.lastName}")
        Text(text = "Мобильный телефон: ${contact.phone}")
        Text(text = "Адрес: ${contact.address}")
    }
}

@Composable
fun ContactRow(contact: ContactInfo, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ContactColumn(contact = contact, modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "Star",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ContactListColumn(contacts: List<ContactInfo>, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        for (contact in contacts) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0))
            ) {
                ContactColumn(
                    contact = contact,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@Composable
fun Task7Screen(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Задание 7: Верстка с помощью Column и Row",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Контакт (Column):", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            ContactColumn(contact = sampleContact1)

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Список контактов (Column из карточек):", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            ContactListColumn(contacts = listOf(sampleContact1, sampleContact2, sampleContact3))

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Контакт с иконкой (Row):", fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(4.dp))
            ContactRow(contact = sampleContact1)
        }
    }
}

@Preview(showBackground = true, name = "Contact Column")
@Composable
fun ContactColumnPreview() {
    ContactColumn(contact = sampleContact1)
}

@Preview(showBackground = true, name = "Contact List")
@Composable
fun ContactListPreview() {
    ContactListColumn(contacts = listOf(sampleContact1, sampleContact2, sampleContact3))
}

@Preview(showBackground = true, name = "Contact Row")
@Composable
fun ContactRowPreview() {
    ContactRow(contact = sampleContact1)
}
