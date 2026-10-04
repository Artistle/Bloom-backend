plugins {
    alias(libs.plugins.bloom.spring.web)
}

dependencies {

    implementation(project(":services:auth:auth-api"))
}