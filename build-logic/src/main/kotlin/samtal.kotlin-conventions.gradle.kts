import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("samtal.base-conventions")
    kotlin("jvm")
}

kotlin {
    explicitApi()
    jvmToolchain(17)
    coreLibrariesVersion = "1.9.20"
    target {
        compilations.configureEach {
            kotlinOptions {
                jvmTarget = "17"
                languageVersion = "1.9"
            }
        }
    }
}

dependencies {
    api(kotlin("stdlib-jdk8"))
}

spotless {
    kotlin {
        ktlint(the<LibrariesForLibs>().versions.ktlint.get())
            .editorConfigOverride(
                mapOf(
                    "ktlint_standard_filename" to "disabled",
                    "ktlint_standard_trailing-comma-on-call-site" to "disabled",
                    "ktlint_standard_trailing-comma-on-declaration-site" to "disabled"
                )
            )
    }
}
