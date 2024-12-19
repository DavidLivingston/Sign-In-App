package com.example.signinapp.pages

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick

class TfLAlertDialogue (private val composeTestRule: ComposeTestRule) {
    // Node references
    private val tflAlertDialogue: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("TfLAlertDialog")
    private val tflAlertDialogueMessage: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("AlertDialogMessage")
    private val tflAlertTitle: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("AlertDialogTitle")
    private val confirmButton: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("ConfirmButton")


    // Assertions
    fun assertIsDisplayed(): TfLAlertDialogue {
        tflAlertDialogue.assertIsDisplayed()
        return this
    }
    fun assertTitleIsDisplayed(expectedTitle: String): TfLAlertDialogue {
        tflAlertTitle.assertTextEquals(expectedTitle)
        return this
    }
    fun assertMessageIsDisplayed(expectedMessage: String): TfLAlertDialogue {
        tflAlertDialogueMessage.assertTextEquals(expectedMessage)
        return this
    }
    // Actions
    fun clickConfirm (): TfLAlertDialogue {
        confirmButton.performClick()
        return this
    }
}