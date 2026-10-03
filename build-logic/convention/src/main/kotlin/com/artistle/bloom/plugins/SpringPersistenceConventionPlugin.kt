package com.artistle.bloom.plugins

import com.artistle.bloom.internal.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.allopen.gradle.AllOpenExtension

class SpringPersistenceConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply(SpringLibraryConventionPlugin::class.java)
        pluginManager.apply(Aliases.Plugin.KOTLIN_JPA)

        extensions.configure<AllOpenExtension> {
            annotations(
                "jakarta.persistence.Entity",
                "jakarta.persistence.MappedSuperclass",
                "jakarta.persistence.Embeddable",
            )
        }

        dependencies {
            implementation(libs.bundle(Aliases.Bundle.PERSISTENCE))
            runtimeOnly(libs.library(Aliases.Lib.POSTGRESQL))
        }
    }
}