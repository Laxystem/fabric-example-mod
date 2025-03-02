plugins {
	kotlin("jvm")
	id("fabric-loom")
	`maven-publish`
}


repositories {
	// Add repositories to retrieve artifacts from in here.
	// You should only use this when depending on other mods because
	// Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
	// See https://docs.gradle.org/current/userguide/declaring_repositories.html
	// for more information about repositories.
}

dependencies {
	minecraft(libs.minecraft)
	mappings(variantOf(libs.fabric.yarn) { classifier("v2") })
	modImplementation(libs.fabric)

	// dependencies on other mods
	modImplementation(libs.fabric.kotlin)
	modImplementation(libs.fabric.api)

	// non-mod libraries included in the jar
	implementation(libs.kotlinLogging)
	include(libs.kotlinLogging)
}

kotlin {
	val jvm: String by properties

	jvmToolchain(jvm.toInt())
}

tasks {
	processResources {
		inputs.property("version", project.version)
		filesMatching("fabric.mod.json") {
			expand(getProperties() + mapOf(
				"fabric_kotlin" to libs.fabric.kotlin.get().version,
				"loader" to libs.fabric.asProvider().get().version!!,
				"minecraft" to libs.minecraft.get().version,
				"version" to project.version
			))
		}

		filesMatching("*.mixins.json") {
			expand(getProperties())
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
}

java {
	// Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task
	// if it is present.
	// If you remove this line, sources will not be generated.
	withSourcesJar()
}


// configure the maven publication
