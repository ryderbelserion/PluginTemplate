plugins {
    id("paper-plugin")
}

project.group = "${rootProject.group}.paper"

repositories {

}

dependencies {
    implementation(project(":common"))

    implementation("org.bstats", "bstats-bukkit", "3.0.2")

    implementation(libs.cluster.bukkit.api) {
        exclude("com.ryderbelserion.cluster", "cluster-api")
    }
}

val component: SoftwareComponent = components["java"]

tasks {
    shadowJar {
        listOf(
            "com.ryderbelserion.cluster",
            "org.bstats"
        ).forEach {
            relocate(it, "libs.$it")
        }
    }

    processResources {
        val props = mapOf(
            "name" to rootProject.name,
            "group" to project.group.toString(),
            "version" to rootProject.version,
            "description" to rootProject.description,
            "authors" to rootProject.properties["authors"],
            "apiVersion" to "1.20",
            "website" to "https://modrinth.com/plugin/${rootProject.name.lowercase()}"
        )

        filesMatching("plugin.yml") {
            expand(props)
        }
    }
}