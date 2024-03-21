plugins {
    id("if.plugin.library")
    id("if.plugin.hilt")
}

android {
    namespace = "ifyouwant.data"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(libs.dataStore)
}