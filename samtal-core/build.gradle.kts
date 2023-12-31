plugins {
    id("samtal.base-conventions")
}

dependencies {
    api(project(":samtal-discord"))

    api(libs.feign)
    api(libs.feignJackson)
    api(libs.jacksonDatabind)

    annotationProcessor(libs.immutables)
    implementation(libs.immutables)
}
