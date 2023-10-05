plugins {
    id("com.github.johnrengelman.shadow")

    `maven-publish`
    `java-library`
}

repositories {
    maven("https://repo.crazycrew.us/releases/")

    maven("https://jitpack.io")

    mavenCentral()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of("17"))
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }
}