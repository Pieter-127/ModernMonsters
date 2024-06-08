package com.pieterv.modernmonsters.buildsrc.functions

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider

fun DependencyHandler.implementation(dependency: Provider<MinimalExternalModuleDependency>) {
    add("implementation", dependency)
}

fun DependencyHandler.implementation(dependency: LibrariesForLibs.AndroidxUiLibraryAccessors) {
    add("implementation", dependency)
}

fun DependencyHandler.test(dependency: Provider<MinimalExternalModuleDependency>) {
    add("testImplementation", dependency)
}

fun DependencyHandler.androidTest(dependency: Provider<MinimalExternalModuleDependency>) {
    add("androidTestImplementation", dependency)
}

fun DependencyHandler.debugImplementation(dependency: Provider<MinimalExternalModuleDependency>) {
    add("debugImplementation", dependency)
}
fun DependencyHandler.debugImplementation(dependency: LibrariesForLibs.AndroidxUiToolingLibraryAccessors) {
    add("debugImplementation", dependency)
}

fun DependencyHandler.kapt(dependency: Provider<MinimalExternalModuleDependency>) {
    add("kapt", dependency)
}