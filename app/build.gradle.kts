plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.pieterv.kapt")
    id("com.pieterv.hilt")
    id("com.pieterv.serialization")
}

android {
    namespace = "com.pieterv.modernmonsters"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pieterv.modernmonsters"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:design"))
    implementation(project(":feature:list"))
    implementation(project(":feature:detail"))
    implementation(project(":feature:matchup"))
    implementation(project(":feature:typeInfo"))
    implementation(project(":core:domain"))
    implementation(project(":core:network"))
    implementation(project(":core:models"))

    implementation ("androidx.compose.material3:material3-adaptive-navigation-suite:1.0.0-alpha07")
    implementation ("androidx.compose.material3.adaptive:adaptive-navigation:1.0.0-beta02")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}