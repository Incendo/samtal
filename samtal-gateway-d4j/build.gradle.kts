plugins {
    id("samtal.base-conventions")
}

dependencies {
    api(project(":samtal-gateway"))
    api(libs.discord4jGateway)

    // TODO(City): Remove this.
    implementation("org.slf4j:slf4j-jdk14:2.0.9")
}
