package com.pieterv.modernmonsters.buildsrc.functions

import com.android.build.gradle.LibraryExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

internal val Project.libs: LibrariesForLibs get() =
    extensions.getByType<LibrariesForLibs>()

fun Project.android(): LibraryExtension {
    return extensions.getByType(LibraryExtension::class.java)
}