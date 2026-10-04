plugins {
    alias(libs.plugins.bloom.spring.application)
}

dependencies {

    implementation(project(":controllers"))
    implementation(project(":services:auth:auth-api"))
    implementation(project(":services:auth:auth-impl"))
}
