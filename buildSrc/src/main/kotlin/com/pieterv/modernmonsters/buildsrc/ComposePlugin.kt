package com.pieterv.modernmonsters.buildsrc

import com.pieterv.modernmonsters.buildsrc.functions.android
import com.pieterv.modernmonsters.buildsrc.functions.debugImplementation
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

        //design system
        target.dependencies.implementation(target.libs.androidx.ui)
        target.dependencies.implementation(target.libs.androidx.ui.graphics)
        target.dependencies.implementation(target.libs.androidx.ui.tooling.preview)
        target.dependencies.implementation(target.libs.androidx.material3)
        target.dependencies.debugImplementation(target.libs.androidx.ui.tooling)
        target.dependencies.debugImplementation(target.libs.androidx.ui.test.manifest)

        //"features"
        target.dependencies.implementation(target.libs.coil.compose)
    }
}