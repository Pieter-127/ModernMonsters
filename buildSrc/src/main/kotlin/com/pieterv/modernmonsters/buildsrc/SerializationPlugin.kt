package com.pieterv.modernmonsters.buildsrc

import com.pieterv.modernmonsters.buildsrc.functions.implementation
import com.pieterv.modernmonsters.buildsrc.functions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class SerializationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.apply {
            plugin("org.jetbrains.kotlin.plugin.serialization")
        }
        target.dependencies.implementation(target.libs.kotlinx.serialization.json)
    }
}