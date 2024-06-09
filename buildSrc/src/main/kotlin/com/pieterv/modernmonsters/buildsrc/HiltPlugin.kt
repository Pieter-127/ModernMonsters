package com.pieterv.modernmonsters.buildsrc

import com.pieterv.modernmonsters.buildsrc.functions.implementation
import com.pieterv.modernmonsters.buildsrc.functions.kapt
import com.pieterv.modernmonsters.buildsrc.functions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class HiltPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("dagger.hilt.android.plugin")
        }
        target.dependencies.kapt(target.libs.hilt.compiler)
        target.dependencies.implementation(target.libs.hilt.android)
        target.dependencies.implementation(target.libs.hiltNavigation)
        target.dependencies.implementation(target.libs.hiltNavigationCompose)
    }
}