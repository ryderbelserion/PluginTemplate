plugins {
    id("io.papermc.paperweight.userdev")

    id("root-plugin")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    paperweight.paperDevBundle("${rootProject.properties["minecraftVersion"]}-R0.1-SNAPSHOT")
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }

    reobfJar {
        outputJar.set(file("${project.layout.buildDirectory.get()}/libs/${rootProject.name}-${rootProject.version}.jar"))
    }
}