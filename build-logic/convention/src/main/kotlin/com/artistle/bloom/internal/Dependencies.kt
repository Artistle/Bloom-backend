package com.artistle.bloom.internal

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

internal fun DependencyHandler.implementation(notation: Any): Dependency? =
    add("implementation", notation)

internal fun DependencyHandler.implementationProject(notation: String): Dependency? =
    add("implementation", this.project(notation))

internal fun DependencyHandler.api(notation: Any): Dependency? =
    add("api", notation)

internal fun DependencyHandler.runtimeOnly(notation: Any): Dependency? =
    add("runtimeOnly", notation)

internal fun DependencyHandler.annotationProcessor(notation: Any): Dependency? =
    this.add("annotationProcessor", notation)

internal fun DependencyHandler.debugImplementation(notation: Any): Dependency? =
    add("debugImplementation", notation)

internal fun DependencyHandler.testImplementation(notation: Any): Dependency? =
    add("testImplementation", notation)

internal fun DependencyHandler.androidTestImplementation(notation: Any): Dependency? =
    add("androidTestImplementation", notation)