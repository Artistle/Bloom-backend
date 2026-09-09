package com.artistle.bloom.plugins

import com.artistle.bloom.internal.Aliases
import com.artistle.bloom.internal.bundle
import com.artistle.bloom.internal.implementation
import com.artistle.bloom.internal.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class SpringWebsocketConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        pluginManager.apply(SpringWebConventionPlugin::class.java)

        dependencies {
            implementation(libs.bundle(Aliases.Bundle.WEBSOCKET))
        }
    }
}