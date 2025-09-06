plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.movies_app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.movies_app"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.ui)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Compose & Material3 (تأكد من تطابق الإصدارات مع مشروعك)
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.compose.material3:material3:1.1.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.0")
    // Coil for Compose (image loading)
    implementation("io.coil-kt:coil-compose:2.3.0")
    // Optional: accompanist pager/snapper for better snapping (صفحات مؤشرات)
    implementation("com.google.accompanist:accompanist-pager:0.31.5-beta")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.31.5-beta")
    // Optional: lifecycle-viewmodel compose (if تحتاج)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")


    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.3")
    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.9.3")
    // Voyager  Navigator
    implementation("cafe.adriel.voyager:voyager-navigator:1.1.0-beta02")

    implementation("androidx.compose.foundation:foundation:1.6.0")
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.material3:material3:1.2.0")


    implementation("androidx.compose.material:material-icons-extended:<آخر_إصدار>")

}