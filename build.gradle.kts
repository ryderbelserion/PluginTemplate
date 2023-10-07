plugins {
    id("root-plugin")
}

defaultTasks("build")

rootProject.group = "com.ryderbelserion.template"
rootProject.description = "A plugin template."
rootProject.version = "0.2"

val combineJar = tasks.register<Jar>("combine") {
    mustRunAfter("build")

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    val jarFiles = subprojects.flatMap { subproject ->
        files(subproject.layout.buildDirectory.file("libs/${rootProject.name}-${subproject.version}.jar").get())
    }.filter { it.name != "MANIFEST.MF" }.map { file ->
        if (file.isDirectory) file else zipTree(file)
    }

    from(jarFiles)
}

tasks {
    assemble {
        subprojects.forEach { project ->
            dependsOn(":${project.name}:build")
        }

        finalizedBy(combineJar)
    }
}