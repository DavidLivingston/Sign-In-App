package com.example.signinapp.tests

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.signinapp.MainActivity
import com.example.signinapp.R
import com.example.signinapp.pages.LoginPage
import com.example.signinapp.pages.MyTfLPage
import com.example.signinapp.pages.TfLAlertDialogue
import org.junit.Rule
import org.junit.Test

class MyTfLPageTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val loginPage = LoginPage(composeTestRule)
    private val myTfLPage = MyTfLPage(composeTestRule)
    private val alertDialog = TfLAlertDialogue(composeTestRule)
/*
 3. Login successfully and test the following elements exist
    a. Name Label = Emma Smith
    b. Role label = Senior Test Analyst
    c. Office = Pier Walk
* */
    @Test
    fun testMyTfLPageDisplaysCorrectly() {
        // Perform login first
        loginPage
            .enterTfLID("emma@tfl.gov.uk")
            .enterPassword("password123")
            .clickSignIn()

        // Assertions on MyTfLPage
        val expectedTitle = composeTestRule.activity.getString(R.string.my_tfl)
        val expectedNameLabel = composeTestRule.activity.getString(R.string.name)
        val expectedNameValue = "Emma Smith"
        val expectedRoleLabel = composeTestRule.activity.getString(R.string.role)
        val expectedRoleValue = "Senior Test Analyst"
        val expectedOfficeLabel = composeTestRule.activity.getString(R.string.office)
        val expectedOfficeValue = "Pier Walk"

        myTfLPage
            .assertLogoIsDisplayed()
            .assertTitleIsDisplayed(expectedTitle)
            .assertStaffNameIsDisplayed(expectedNameLabel, expectedNameValue)
            .assertStaffRoleIsDisplayed(expectedRoleLabel, expectedRoleValue)
            .assertStaffOfficeIsDisplayed(expectedOfficeLabel, expectedOfficeValue)
            .assertSignOutButtonIsDisplayed()
    }
//4. Login then sign out and check you’re back on the login screen
    @Test
    fun testSignOutProcess() {
        // Perform login first
        loginPage
            .enterTfLID("emma@tfl.gov.uk")
            .enterPassword("password123")
            .clickSignIn()

        // Click on Sign Out
        myTfLPage.clickSignOut()

        // Assert the alert dialog is displayed
        val alertTitle = composeTestRule.activity.getString(R.string.sign_out_alert_title)
        val alertMessage = composeTestRule.activity.getString(R.string.sign_out_alert_message)

        alertDialog
            .assertIsDisplayed()
            .assertTitleIsDisplayed(alertTitle)
            .assertMessageIsDisplayed(alertMessage)
            .clickConfirm()

        // Optionally, verify that we're back on the LoginPage
        loginPage.assertLogoIsDisplayed()
    }
}
