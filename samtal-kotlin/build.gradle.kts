plugins {
    id("samtal.kotlin-conventions")
}

dependencies {
    api(projects.samtalCore)
    api(libs.feignKotlin)
}
