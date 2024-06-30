plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.pieterv.projectversion")
    id("com.pieterv.kapt")
    id("com.pieterv.hilt")
    id("com.pieterv.serialization")
    id("com.pieterv.compose")
}

android {
    namespace = "com.pieterv.typeinfo"

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
    implementation(project(":core:design"))
    implementation(project(":core:domain"))
    implementation(project(":core:common"))
    implementation(project(":core:models"))
    implementation(project(":core:components"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}