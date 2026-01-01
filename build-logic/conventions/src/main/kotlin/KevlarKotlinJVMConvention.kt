import helpers.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

class KevlarKotlinJVMConvention : Plugin<Project> {
	override fun apply(project: Project): Unit = with(project) {
		plugins.apply(libs.findPlugin("kotlin-jvm").get().get().pluginId)

		extensions.configure<KotlinJvmProjectExtension> {
			jvmToolchain(23)
		}
	}
}