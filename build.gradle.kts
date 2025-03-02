plugins {
	alias(libs.plugins.fabric) apply false
	alias(libs.plugins.kotlin) apply false
}

val mavenGroup = properties["group"]!!.toString()
val projectVersion = properties["version"]!!.toString()

allprojects {
	group = mavenGroup
	version = projectVersion
}
