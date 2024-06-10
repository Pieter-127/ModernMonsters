package com.pieterv.modernmonsters.buildsrc

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.pieterv.modernmonsters.buildsrc.functions.*

class ProjectVersionPlugin : Plugin<Project> {

    private val appMinSdk = 24
    private val appCompileSdk = 33
    private val appJvmTarget = "17"

    override fun apply(target: Project) {
        setProjectConfig(target)
    }

    private fun setProjectConfig(project: Project) {
        project.android().apply {
            compileSdk = appCompileSdk

            defaultConfig {
                minSdk = appMinSdk
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }

        }
        project.tasks.withType(KotlinCompile::class.java).configureEach {
            kotlinOptions {
                jvmTarget = appJvmTarget
            }
        }
    }
}