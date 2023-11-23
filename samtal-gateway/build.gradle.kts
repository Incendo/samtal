plugins {
    id("samtal.base-conventions")
}

dependencies {
    api(project(":samtal-discord"))

    annotationProcessor(libs.immutables)
    implementation(libs.immutables)
}
