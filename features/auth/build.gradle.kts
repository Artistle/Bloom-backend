plugins {
    alias(libs.plugins.bloom.spring.web)
}

dependencies {

    implementation(project(":entities:web-entities"))
    implementation(project(":entities:domain-entities"))
}
