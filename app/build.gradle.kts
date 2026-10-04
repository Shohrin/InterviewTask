plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")

    // Apply Dagger Hilt
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.example.interviewtask"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.interviewtask"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
    // Retrofit (Core Network Library)
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    // Retrofit Converter (Converts JSON to Kotlin Objects)
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // OkHttp (HTTP Client and Interceptors)
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp")
    // Logging Interceptor (Essential for debugging API requests in Logcat)
    implementation("com.squareup.okhttp3:logging-interceptor")
    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.60.1")
    ksp("com.google.dagger:hilt-android-compiler:2.60.1")
    implementation("androidx.navigation:navigation-compose:2.8.5")
    // Jetpack Compose Hilt Navigation Support
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    // Standard testing framework
    testImplementation("junit:junit:4.13.2")

    // ADD THIS LINE TO FIX THE UNRESOLVED IMPORT ERROR
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.9.0") // 👈 Updates coroutines test API scope

    // Mocking library (needed for mockk functions used in the test)
    testImplementation("io.mockk:mockk:1.13.12")
}