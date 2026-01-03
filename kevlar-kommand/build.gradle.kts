plugins {
    alias(libs.plugins.kevlarConventions.kotlin.jvm)
    alias(libs.plugins.kevlarConventions.kotlin.test)
    alias(libs.plugins.kevlarConventions.kotlin.repositories)
}

kotlin.compilerOptions {
    freeCompilerArgs.add("-Xcontext-parameters")
}