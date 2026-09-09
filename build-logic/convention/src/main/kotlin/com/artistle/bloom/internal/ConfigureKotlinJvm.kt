package com.artistle.bloom.internal

import com.artistle.bloom.config.ProjectConfig
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

internal fun Project.configureKotlinJvm() {
    group = ProjectConfig.GROUP
    version = ProjectConfig.VERSION

    extensions.configure<JavaPluginExtension> {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(ProjectConfig.JAVA_VERSION))
        }
    }

    extensions.configure<KotlinJvmProjectExtension> {
        compilerOptions {
            jvmTarget.set(ProjectConfig.JVM_TARGET)
            optIn.addAll(ProjectConfig.OPT_INS)
            allWarningsAsErrors.set(
                providers.gradleProperty("warningsAsErrors").map(String::toBoolean).orElse(false)
            )
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}