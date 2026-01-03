import helpers.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.maven

class KevlarKotlinRepositoriesConvention : Plugin<Project> {
	override fun apply(project: Project): Unit = with(project) {
		repositories.apply {
			mavenCentral()

			libs.versionAliases.filter { it.startsWith("repo") }.forEach { alias ->
				val url = libs.findVersion(alias).get().displayName
				maven(url) {
					name = alias
				}
			}
		}
	}
}