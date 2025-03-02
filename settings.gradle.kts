rootProject.name = "fabric-example-mod-kotlin"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(
	"core",
	// you can add more subprojects, e.g.
	// "library",
)

pluginManagement.repositories {
	maven(url = "https://maven.fabricmc.net/") {
		name = "Fabric"
	}
	mavenCentral()
	gradlePluginPortal()
}
