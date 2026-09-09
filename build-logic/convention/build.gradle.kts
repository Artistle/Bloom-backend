plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

java {
    toolchain { languageVersion = JavaLanguageVersion.of(21) }
}

group = "com.artistle.bloom.buildlogic"
version = "1.0-SNAPSHOT"

tasks.validatePlugins {
    enableStricterValidation = true
    failOnWarning = true
}

dependencies {

    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.spring.boot.gradle.plugin)
    implementation(libs.kotlin.allopen.plugin)
    implementation(libs.kotlin.noarg.plugin)
}

gradlePlugin {
    plugins {
        register("kotlinLibrary") {
            id = "bloom.kotlin.library"
            implementationClass = "com.artistle.bloom.plugins.KotlinLibraryConventionPlugin"
        }
        register("springLibrary") {
            id = "bloom.spring.library"
            implementationClass = "com.artistle.bloom.plugins.SpringLibraryConventionPlugin"
        }
        register("springWeb") {
            id = "bloom.spring.web"
            implementationClass = "com.artistle.bloom.plugins.SpringWebConventionPlugin"
        }
        register("springPersistence") {
            id = "bloom.spring.persistence"
            implementationClass = "com.artistle.bloom.plugins.SpringPersistenceConventionPlugin"
        }
        register("springSecurity") {
            id = "bloom.spring.security"
            implementationClass = "com.artistle.bloom.plugins.SpringSecurityConventionPlugin"
        }
        register("springWebsocket") {
            id = "bloom.spring.websocket"
            implementationClass = "com.artistle.bloom.plugins.SpringWebsocketConventionPlugin"
        }
        register("springApplication") {
            id = "bloom.spring.application"
            implementationClass = "com.artistle.bloom.plugins.SpringApplicationConventionPlugin"
        }
    }
}
