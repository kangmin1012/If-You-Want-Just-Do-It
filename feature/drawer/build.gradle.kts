plugins {
    id("if.plugin.library")
    id("if.plugin.library.compose")
    id("if.plugin.hilt")
}

android {
    namespace = "ifyouwant.feature.drawer"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
}