plugins {
    id("java")
    id("dev.architectury.loom") version("1.1-SNAPSHOT")
    id("architectury-plugin") version("3.4-SNAPSHOT")
    id("fabric-loom")
    `maven-publish`
    kotlin("jvm") version ("1.7.10")
}

group = property("maven_group")!!
version = property("mod_version")!!

architectury {
    platformSetupLoomIde()
    fabric()
}

repositories {
    mavenCentral()
    maven(url = "https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
    maven("https://maven.impactdev.net/repository/development/")
    maven {
        url = uri("https://cursemaven.com")
        content {
            includeGroup("curse.maven")
        }
    }
}

dependencies {
    minecraft("com.mojang:minecraft:${property("minecraft_version")}")
    mappings("net.fabricmc:yarn:${property("yarn_mappings")}")
    modImplementation("net.fabricmc:fabric-loader:${property("loader_version")}")

    // Fabric API
    modImplementation("net.fabricmc.fabric-api:fabric-api:${property("fabric_version")}")

    // Architectury
    modImplementation("dev.architectury", "architectury-fabric", "6.5.69")

    // Cobblemon
    modImplementation("curse.maven:cobblemon-687131:${property("cobblemon_curse_file_id")}")

    // Uncomment for configs
    // implementation("com.google.code.gson:gson:2.8.5")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks {

    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }

    jar {
        from("LICENSE")
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                artifact(remapJar) {
                    builtBy(remapJar)
                }
                artifact(kotlinSourcesJar) {
                    builtBy(remapSourcesJar)
                }
            }
        }

        // select the repositories you want to publish to
        repositories {
            // uncomment to publish to the local maven
            // mavenLocal()
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }

}

java {
    withSourcesJar()
}
