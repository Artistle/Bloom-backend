package com.artistle.bloom.config

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

internal object ProjectConfig {
    const val GROUP = "com.artistle.bloom"
    const val VERSION = "0.1.0-SNAPSHOT"

    const val JAVA_VERSION = 21
    val JVM_TARGET = JvmTarget.JVM_21

    val OPT_INS = listOf(
        "kotlin.time.ExperimentalTime",
    )
}