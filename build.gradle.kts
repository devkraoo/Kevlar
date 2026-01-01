plugins {
	alias(libs.plugins.kelvar.kotlin.jvm)
}

group = "me.devkraoo"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	testImplementation(kotlin("test"))
}

tasks.test {
	useJUnitPlatform()
}