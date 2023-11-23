plugins {
    id("samtal.base-conventions")
}

dependencies {
    api(libs.jacksonDatabind)

    annotationProcessor(libs.immutables)
    implementation(libs.immutables)
}
