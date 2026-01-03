import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskContainer
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.named

class KevlarKotlinTestConvention : Plugin<Project> {
	override fun apply(project: Project): Unit = with(project) {
		dependencies.add("testImplementation", dependencies.kotlin("test"))

		tasks.test {
			useJUnitPlatform()
		}
	}
}


private fun TaskContainer.test(configure: Test.() -> Unit) =
	named<Test>("test").configure(configure)