import com.diffplug.gradle.spotless.FormatExtension
import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("net.kyori.indra")
    id("net.kyori.indra.checkstyle")
    id("com.diffplug.spotless")
}

indra {
    javaVersions {
        minimumToolchain(17)
        target(17)
        testWith(17, 21)
    }
    checkstyle(the<LibrariesForLibs>().versions.checkstyle.get())
}

tasks {
    withType<JavaCompile> {
        options.compilerArgs.addAll(listOf("-Xlint:-processing", "-Werror"))
    }
}

spotless {
    fun FormatExtension.applyCommon(spaces: Int = 4) {
        indentWithSpaces(spaces)
        trimTrailingWhitespace()
        endWithNewline()
    }
    java {
        licenseHeaderFile(rootProject.file("HEADER"))
        importOrderFile(rootProject.file(".spotless/samtal.importorder"))
        applyCommon()
    }
    kotlin {
        licenseHeaderFile(rootProject.file("HEADER"))
        applyCommon()
    }
    kotlinGradle {
        ktlint(the<LibrariesForLibs>().versions.ktlint.get())
    }
    format("configs") {
        target("**/*.yml", "**/*.yaml", "**/*.json")
        applyCommon(2)
    }
}

// Common dependencies.
dependencies {
}
