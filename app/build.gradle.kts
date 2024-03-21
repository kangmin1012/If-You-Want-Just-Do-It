plugins {
    id("if.plugin.application")
    id("if.plugin.application.compose")
    id("if.plugin.hilt")
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":feature:drawer"))
    implementation(project(":feature:userinfo"))
}