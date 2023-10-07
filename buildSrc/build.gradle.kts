plugins {
    `kotlin-dsl`
}

dependencies {
    implementation("fabric-loom", "fabric-loom.gradle.plugin", "1.4-SNAPSHOT")

    implementation("io.papermc.paperweight", "paperweight-userdev", "1.5.5")

    implementation("com.github.johnrengelman", "shadow", "8.1.1")
}