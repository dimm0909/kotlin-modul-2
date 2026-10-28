package com.example.kotlinemodule2

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Задание 9:
 * UI тесты для приложения WaterTracker (Задание 8):
 * 1) Проверить наличие и корректную работу кнопки добавления жидкости (+250 мл).
 * 2) Проверить наличие и корректную работу кнопки «Завершить день».
 * 3) Проверить выведение текста количества дней подряд с нормой 1500+ мл.
 */
@RunWith(AndroidJUnit4::class)
class Task9UiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun test1AddWaterButton() {
        composeTestRule.setContent {
            WaterTracker()
        }

        composeTestRule.onNodeWithTag("water_count_text").assertTextEquals("0 мл")
        composeTestRule.onNodeWithTag("add_water_button").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithTag("water_count_text").assertTextEquals("250 мл")
    }

    @Test
    fun test2CompleteDayButton() {
        composeTestRule.setContent {
            WaterTracker()
        }

        // Кнопка должна присутствовать
        composeTestRule.onNodeWithTag("complete_day_button").assertIsDisplayed()

        // Добавляем 1500 мл (6 кликов по +250 мл)
        repeat(6) {
            composeTestRule.onNodeWithTag("add_water_button").performClick()
        }
        composeTestRule.onNodeWithTag("water_count_text").assertTextEquals("1500 мл")

        // Завершаем день
        composeTestRule.onNodeWithTag("complete_day_button").performClick()

        // Количество воды должно сброситься до 0 мл
        composeTestRule.onNodeWithTag("water_count_text").assertTextEquals("0 мл")
    }

    @Test
    fun test3StreakTextDisplayed() {
        composeTestRule.setContent {
            WaterTracker()
        }

        // Проверяем начальный вывод количества дней
        composeTestRule.onNodeWithTag("streak_days_text").assertIsDisplayed()
        composeTestRule.onNodeWithText("Дней с нормой 1500+ мл подряд: 0").assertIsDisplayed()

        // Добавляем 1500 мл и завершаем день
        repeat(6) {
            composeTestRule.onNodeWithTag("add_water_button").performClick()
        }
        composeTestRule.onNodeWithTag("complete_day_button").performClick()

        // Проверяем, что количество дней стало 1
        composeTestRule.onNodeWithText("Дней с нормой 1500+ мл подряд: 1").assertIsDisplayed()
    }
}

private fun androidx.compose.ui.test.SemanticsNodeInteraction.assertTextEquals(expected: String) {
    this.assertExists()
    this.assert(androidx.compose.ui.test.hasText(expected))
}
