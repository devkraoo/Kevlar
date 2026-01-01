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
			id = libs.plugins.kelvar.kotlin.jvm.get().pluginId
			implementationClass = "KevlarKotlinJVMConvention"
		}
	}
}