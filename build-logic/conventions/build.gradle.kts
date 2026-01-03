plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {
	plugins {
		register("KevlarKotlinJVMConvention") {
			id = libs.plugins.kevlarConventions.kotlin.jvm.get().pluginId
			implementationClass = "KevlarKotlinJVMConvention"
		}

		register("KevlarKotlinTestConvention") {
			id = libs.plugins.kevlarConventions.kotlin.test.get().pluginId
			implementationClass = "KevlarKotlinTestConvention"
		}

		register("KevlarKotlinRepositoriesConvention") {
			id = libs.plugins.kevlarConventions.kotlin.repositories.get().pluginId
			implementationClass = "KevlarKotlinRepositoriesConvention"
		}
	}
}