import helpers.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

class KevlarKotlinJVMConvention : Plugin<Project> {
	override fun apply(project: Project): Unit = with(project) {
		val pluginId = libs.findPlugin("kotlin-jvm").get().get().pluginId
		plugins.apply(pluginId)

		kotlin {
			val version = libs.findVersion("jvm").get().strictVersion.toInt()
			jvmToolchain(version)
		}
	}
}

private fun Project.kotlin(configure: KotlinJvmProjectExtension.() -> Unit) =
	extensions.configure(configure)