enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

plugins {
	id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "kevlar"

val projects = listOf(
	"kevlar-kommand"
)
include(projects)

includeBuild("build-logic")