package com.artistle.bloom.internal

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureSpringPlatform() {

    dependencies {
        val bom = platform(libs.library(Aliases.Lib.SPRING_BOOT_BOM))
        implementation(bom)
        testImplementation(bom)
        annotationProcessor(bom)
    }
    dependencies {
        val bom = platform(libs.library(Aliases.Lib.SPRING_BOOT_BOM))
        implementation(bom)
        testImplementation(bom)
        annotationProcessor(bom)
    }
}
