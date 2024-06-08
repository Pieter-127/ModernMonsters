import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinGradle)
    implementation(libs.gradle)

    /** Work around to include ../.gradle/LibrariesForLibs generated file for version catalog */
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation("com.squareup:javapoet:1.13.0")
}

//val compileKotlin: KotlinCompile by tasks
//compileKotlin.kotlinOptions {
//    jvmTarget = "17"
//}