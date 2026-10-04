plugins {
    alias(libs.plugins.bloom.spring.application)
}

dependencies {

    implementation(project(":features:auth"))
}
