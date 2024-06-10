package com.pieterv.modernmonsters.buildsrc

import com.pieterv.modernmonsters.buildsrc.functions.implementation
import com.pieterv.modernmonsters.buildsrc.functions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class PagingPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.dependencies.implementation(target.libs.androidx.paging.runtime.ktx)
    }

}