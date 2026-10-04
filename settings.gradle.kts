pluginManagement {
    includeBuild("build-logic")

    plugins {
        id("org.springframework.boot") version "3.2.5"
        id("io.spring.dependency-management") version "1.1.3"
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "bloom"

include("app")
//include("controllers")
//include("services")
//include("services:auth")
include("entities")
include("entities:web-entities")
//include("services:auth:auth-api")
//include("services:auth:auth-impl")
include("entities:domain-entities")
include("features")
include("features:auth")