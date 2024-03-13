plugins {
    id("if.plugin.application")
    id("if.plugin.compose")
    id("if.plugin.hilt")
}

dependencies {
    implementation(project(":core:domain"))
}