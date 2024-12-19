package com.example.signinapp.tests

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.signinapp.MainActivity
import com.example.signinapp.pages.LoginPage
import com.example.signinapp.pages.TfLAlertDialogue
import com.example.signinapp.R
import org.junit.Rule
import org.junit.Test

class LoginPageTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val loginPage = LoginPage(composeTestRule)
    private val alertDialog = TfLAlertDialogue(composeTestRule)
//2. Successful login Test
    @Test
    fun testSuccessfulLogin() {
        loginPage
            .assertLogoIsDisplayed()
            .enterTfLID("emma@tfl.gov.uk")
            .enterPassword("password123")
            .assertSignInButtonIsDisplayed()
            .clickSignIn()
    }
// 1. Failed login Test
    @Test
    fun testFailedLogin() {
        val errorTitle = composeTestRule.activity.getString(R.string.login_error_title)
        val errorMessage = composeTestRule.activity.getString(R.string.login_error_message)

        loginPage
            .assertLogoIsDisplayed()
            .enterTfLID("invalid@tfl.gov.uk")
            .enterPassword("wrongpassword")
            .clickSignIn()

        alertDialog
            .assertIsDisplayed()
            .assertTitleIsDisplayed(errorTitle)
            .assertMessageIsDisplayed(errorMessage)
            .clickConfirm()
    }
}
