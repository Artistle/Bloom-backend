plugins {
    kotlin("jvm") version "2.2.10"
}

group = "com.artistle"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

allprojects {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}
