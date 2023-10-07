plugins {
    id("root-plugin")

    id("fabric-loom")
}

project.group = "${rootProject.group}.fabric"
project.version = rootProject.version

base {
    archivesName.set(rootProject.name)
}

dependencies {
    minecraft("com.mojang:minecraft:${rootProject.properties["minecraftVersion"]}")

    mappings(loom.officialMojangMappings())

    modImplementation("net.fabricmc", "fabric-loader", rootProject.properties["loader_version"].toString())
    modImplementation("net.fabricmc.fabric-api", "fabric-api", rootProject.properties["fabric_version"].toString())
}