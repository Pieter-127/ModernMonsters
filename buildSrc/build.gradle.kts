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

    /** Workaround to include ../.gradle/LibrariesForLibs generated file for version catalog */
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.javapoet)
    implementation(libs.kotlinx.serialization.json)
}