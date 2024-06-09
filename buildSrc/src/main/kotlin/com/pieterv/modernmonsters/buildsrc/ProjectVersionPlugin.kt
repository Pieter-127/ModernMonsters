package com.pieterv.modernmonsters.buildsrc

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class ProjectVersionPlugin : Plugin<Project> {

    private val appMinSdk = 24
    private val appCompileSdk = 33
    private val appJvmTarget = "17"
    private val appKotlinCompilerExtensionVersion = "1.5.14"

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

                composeOptions {
                kotlinCompilerExtensionVersion = appKotlinCompilerExtensionVersion
            }
        }
        project.tasks.withType(KotlinCompile::class.java).configureEach {
             kotlinOptions {
                jvmTarget = appJvmTarget
            }
        }
    }

    private fun Project.android(): LibraryExtension {
        return extensions.getByType(LibraryExtension::class.java)
    }
}