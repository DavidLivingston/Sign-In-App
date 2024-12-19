package com.example.signinapp.util

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsNodeInteraction
// Extension function to get text from a SemanticsNodeInteraction
fun SemanticsNodeInteraction.getText(): String {
    return this.fetchSemanticsNode().config[SemanticsProperties.Text].joinToString(separator = "")
}
