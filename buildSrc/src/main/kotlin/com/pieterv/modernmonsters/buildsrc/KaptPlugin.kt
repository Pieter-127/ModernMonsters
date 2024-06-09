package com.pieterv.modernmonsters.buildsrc

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.pieterv.modernmonsters.buildsrc.functions.*
import com.pieterv.modernmonsters.buildsrc.functions.libs

class KaptPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.apply {
            plugin("kotlin-kapt")
        }
    }
}