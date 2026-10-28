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

        composeTestRule.onNodeWithTag("complete_day_button").assertIsDisplayed()

        repeat(6) {
            composeTestRule.onNodeWithTag("add_water_button").performClick()
        }
        composeTestRule.onNodeWithTag("water_count_text").assertTextEquals("1500 мл")

        composeTestRule.onNodeWithTag("complete_day_button").performClick()

        composeTestRule.onNodeWithTag("water_count_text").assertTextEquals("0 мл")
    }

    @Test
    fun test3StreakTextDisplayed() {
        composeTestRule.setContent {
            WaterTracker()
        }

        composeTestRule.onNodeWithTag("streak_days_text").assertIsDisplayed()
        composeTestRule.onNodeWithText("Дней с нормой 1500+ мл подряд: 0").assertIsDisplayed()

        repeat(6) {
            composeTestRule.onNodeWithTag("add_water_button").performClick()
        }
        composeTestRule.onNodeWithTag("complete_day_button").performClick()

        composeTestRule.onNodeWithText("Дней с нормой 1500+ мл подряд: 1").assertIsDisplayed()
    }
}

private fun androidx.compose.ui.test.SemanticsNodeInteraction.assertTextEquals(expected: String) {
    this.assertExists()
    this.assert(androidx.compose.ui.test.hasText(expected))
}
