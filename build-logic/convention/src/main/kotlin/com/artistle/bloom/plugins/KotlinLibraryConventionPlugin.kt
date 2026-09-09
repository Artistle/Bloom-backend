package com.artistle.bloom.plugins

import com.artistle.bloom.internal.Aliases
import com.artistle.bloom.internal.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply(Aliases.Plugin.KOTLIN_JVM)
        pluginManager.apply(Aliases.Plugin.JAVA_LIBRARY)

        configureKotlinJvm()
    }
}