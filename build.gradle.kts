// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.kotlinGradle)
        classpath(libs.gradle)
        classpath(libs.hilt.agp)
    }
}