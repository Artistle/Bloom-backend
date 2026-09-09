package com.artistle.bloom.plugins

import com.artistle.bloom.internal.Aliases
import com.artistle.bloom.internal.configureSpringPlatform
import com.artistle.bloom.internal.implementation
import com.artistle.bloom.internal.library
import com.artistle.bloom.internal.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class SpringLibraryConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply(KotlinLibraryConventionPlugin::class.java)
        pluginManager.apply(Aliases.Plugin.KOTLIN_SPRING)

        configureSpringPlatform()

        dependencies {
            implementation(libs.library(Aliases.Lib.SPRING_BOOT_STARTER))
            implementation(libs.library(Aliases.Lib.KOTLIN_REFLECT))
        }
    }
}