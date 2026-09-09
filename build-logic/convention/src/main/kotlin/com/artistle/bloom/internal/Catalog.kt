package com.artistle.bloom.internal

import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.artifacts.*
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun VersionCatalog.library(alias: String): Provider<MinimalExternalModuleDependency> =
    findLibrary(alias).orElseThrow { missing("library", alias) }

internal fun VersionCatalog.bundle(alias: String): Provider<ExternalModuleDependencyBundle> =
    findBundle(alias).orElseThrow { missing("bundle", alias) }

private fun missing(kind: String, alias: String) = GradleException(
    "В gradle/libs.versions.toml не найден $kind '$alias'"
)