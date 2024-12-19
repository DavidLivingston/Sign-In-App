package com.example.signinapp.pages

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick

class MyTfLPage(private val composeTestRule: ComposeTestRule) {

    // Node references
    private val logo: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("TfLLogo")

    private val title: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("MyTfLTitle")

    private val staffNameLabel: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("Name:_Label")

    private val staffNameValue: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("Name:_Value")

    private val staffRoleLabel: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("Role:_Label")

    private val staffRoleValue: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("Role:_Value")

    private val staffOfficeLabel: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("Office:_Label")

    private val staffOfficeValue: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("Office:_Value")

    private val signOutButton: SemanticsNodeInteraction
        get() = composeTestRule.onNodeWithTag("SignOutButton")

    // Actions
    fun clickSignOut(): MyTfLPage {
        signOutButton.performClick()
        return this
    }

    // Assertions
    fun assertLogoIsDisplayed(): MyTfLPage {
        logo.assertIsDisplayed()
        return this
    }

    fun assertTitleIsDisplayed(expectedTitle: String): MyTfLPage {
        composeTestRule.waitForIdle() // Wait for the UI to stabilize
        title.assertIsDisplayed()
            .assertTextEquals(expectedTitle)
        return this
    }

    fun assertStaffNameIsDisplayed(expectedLabel: String, expectedValue: String): MyTfLPage {
        staffNameLabel.assertIsDisplayed()
            .assertTextEquals(expectedLabel)
        staffNameValue.assertIsDisplayed()
            .assertTextEquals(expectedValue)
        return this
    }

    fun assertStaffRoleIsDisplayed(expectedLabel: String, expectedValue: String): MyTfLPage {
        staffRoleLabel.assertIsDisplayed()
            .assertTextEquals(expectedLabel)
        staffRoleValue.assertIsDisplayed()
            .assertTextEquals(expectedValue)
        return this
    }

    fun assertStaffOfficeIsDisplayed(expectedLabel: String, expectedValue: String): MyTfLPage {
        staffOfficeLabel.assertIsDisplayed()
            .assertTextEquals(expectedLabel)
        staffOfficeValue.assertIsDisplayed()
            .assertTextEquals(expectedValue)
        return this
    }

    fun assertSignOutButtonIsDisplayed(): MyTfLPage {
        signOutButton.assertIsDisplayed()
        return this
    }
}
