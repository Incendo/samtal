plugins {
    id("samtal.base-conventions")
}

dependencies {
    api(project(":samtal-discord"))
    api(libs.slf4j)
    api(libs.immutables)

    annotationProcessor(libs.immutables)
}
