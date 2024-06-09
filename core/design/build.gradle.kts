plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.pieterv.design")
    id("com.pieterv.projectversion")
    id("com.pieterv.compose")
}

android {
    namespace = "com.pieterv.design"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}