buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.kotlinGradle)
        classpath(libs.gradle)
        classpath(libs.hilt.agp)
        classpath(libs.kotlin.serialization)
    }
}