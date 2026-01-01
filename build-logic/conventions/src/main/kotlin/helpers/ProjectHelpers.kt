package helpers

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension

val Project.libs: VersionCatalog
	get() =
		extensions.findByType(VersionCatalogsExtension::class.java)?.named("libs")
			?: error("Version catalog 'libs' not found")