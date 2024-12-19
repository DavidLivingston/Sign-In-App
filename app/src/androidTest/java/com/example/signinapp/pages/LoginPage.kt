package com.example.signinapp.pages

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.assertIsDisplayed

class LoginPage(private val composeTestRule: ComposeTestRule) {

    // Node references
    private val logo
        get() = composeTestRule.onNodeWithTag("TfLLogo")

    private val tflIdInput
        get() = composeTestRule.onNodeWithTag("TfLIDInput")

    private val passwordInput
        get() = composeTestRule.onNodeWithTag("PasswordInput")

    private val signInButton
        get() = composeTestRule.onNodeWithTag("SignInButton")

    // Actions
    fun enterTfLID(tflId: String): LoginPage {
        tflIdInput.performTextInput(tflId)
        return this
    }

    fun enterPassword(password: String): LoginPage {
        passwordInput.performTextInput(password)
        return this
    }

    fun clickSignIn(): LoginPage {
        signInButton.performClick()
        return this
    }

    // Assertions
    fun assertLogoIsDisplayed(): LoginPage {
        logo.assertIsDisplayed()
        return this
    }

    fun assertSignInButtonIsDisplayed(): LoginPage {
        signInButton.assertIsDisplayed()
        return this
    }
}
