pluginManagement {
    repositories {
        maven("https://repo.papermc.io/repository/maven-public/")

        maven("https://maven.fabricmc.net/")

        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "PluginTemplate"

listOf(
    "paper",
    "fabric",

    "common"
).forEach {
    include(it)
}