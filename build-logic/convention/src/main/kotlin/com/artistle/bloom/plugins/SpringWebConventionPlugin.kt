package com.artistle.bloom.plugins

import com.artistle.bloom.internal.Aliases
import com.artistle.bloom.internal.implementation
import com.artistle.bloom.internal.library
import com.artistle.bloom.internal.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class SpringWebConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply(SpringLibraryConventionPlugin::class.java)

        dependencies {
            implementation(libs.library(Aliases.Lib.SPRING_BOOT_STARTER_WEB))
            implementation(libs.library(Aliases.Lib.SPRING_BOOT_STARTER_VALIDATION))
        }
    }
}