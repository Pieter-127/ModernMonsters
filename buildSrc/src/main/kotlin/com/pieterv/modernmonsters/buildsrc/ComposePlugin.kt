package com.pieterv.modernmonsters.buildsrc

import com.pieterv.modernmonsters.buildsrc.functions.android
import com.pieterv.modernmonsters.buildsrc.functions.implementation
import com.pieterv.modernmonsters.buildsrc.functions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposePlugin : Plugin<Project> {

    private val appKotlinCompilerExtensionVersion = "1.5.14"
    override fun apply(target: Project) {

        target.android().apply {
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = appKotlinCompilerExtensionVersion
            }
        }

        target.dependencies.implementation(target.libs.androidx.activity.compose)
        target.dependencies.implementation(target.dependencies.platform(target.libs.androidx.compose.bom))
        target.dependencies.implementation(target.libs.navigation.compose)

    }
}