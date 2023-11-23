plugins {
    id("samtal.base-conventions")
}

dependencies {
    api(project(":samtal-gateway"))
    api(libs.discord4jGateway)
}
