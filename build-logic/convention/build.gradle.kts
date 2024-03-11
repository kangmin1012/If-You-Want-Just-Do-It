plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}

dependencies {
    compileOnly(libs.androidGradlePlugin)
    compileOnly(libs.kotlinGradlePlugin)
}

gradlePlugin {
    plugins {
        register("AndroidApplicationPlugin") {
            id = "if.plugin.application"
            implementationClass = "plugin.AndroidApplicationPlugin"
        }

        register("ComposePlugin") {
            id = "if.plugin.compose"
            implementationClass = "plugin.ComposePlugin"
        }
    }
}