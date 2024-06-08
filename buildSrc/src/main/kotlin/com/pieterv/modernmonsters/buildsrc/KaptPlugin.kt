package com.pieterv.modernmonsters.buildsrc

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.pieterv.modernmonsters.buildsrc.functions.*
import com.pieterv.modernmonsters.buildsrc.functions.libs

class KaptPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.logger.lifecycle("building from ${target.name}")

        target.apply {
            plugin("kotlin-kapt")
            plugin("dagger.hilt.android.plugin")
        }
        target.dependencies.kapt(target.libs.hilt.compiler)
        target.dependencies.implementation(target.libs.hilt.android)
    }
}