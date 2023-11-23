plugins {
    id("samtal.base-conventions")
}

dependencies {
    api(libs.feign)
    api(libs.jacksonDatabind)

    annotationProcessor(libs.immutables)
    implementation(libs.immutables)
}
