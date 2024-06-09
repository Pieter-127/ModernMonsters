package com.pieterv.modernmonsters.buildsrc

import com.pieterv.modernmonsters.buildsrc.functions.*
import org.gradle.api.Plugin
import org.gradle.api.Project

class DesignPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.android().apply {
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = "1.5.14"
            }
        }

        target.dependencies.implementation(target.libs.androidx.activity.compose)
        target.dependencies.implementation(target.dependencies.platform(target.libs.androidx.compose.bom))
        target.dependencies.implementation(target.libs.androidx.ui)
        target.dependencies.implementation(target.libs.androidx.ui.graphics)
        target.dependencies.implementation(target.libs.androidx.ui.tooling.preview)
        target.dependencies.implementation(target.libs.androidx.material3)
        target.dependencies.implementation(target.libs.navigation.compose)
        target.dependencies.debugImplementation(target.libs.androidx.ui.tooling)
        target.dependencies.debugImplementation(target.libs.androidx.ui.test.manifest)
    }
}