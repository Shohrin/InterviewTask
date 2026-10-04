// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
    // Make sure this is defined here with its version string!
    id("com.google.devtools.ksp") version "2.0.20-1.0.25" apply false

    // 2. Dagger Hilt Plugin
    id("com.google.dagger.hilt.android") version "2.60.1" apply false
    kotlin("plugin.serialization") version "2.0.21"
}