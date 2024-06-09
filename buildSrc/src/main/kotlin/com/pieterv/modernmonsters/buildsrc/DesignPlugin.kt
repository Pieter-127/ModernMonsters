package com.pieterv.modernmonsters.buildsrc

import com.pieterv.modernmonsters.buildsrc.functions.*
import org.gradle.api.Plugin
import org.gradle.api.Project

class DesignPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.dependencies.implementation(target.libs.androidx.ui)
        target.dependencies.implementation(target.libs.androidx.ui.graphics)
        target.dependencies.implementation(target.libs.androidx.ui.tooling.preview)
        target.dependencies.implementation(target.libs.androidx.material3)
        target.dependencies.debugImplementation(target.libs.androidx.ui.tooling)
        target.dependencies.debugImplementation(target.libs.androidx.ui.test.manifest)
    }
}