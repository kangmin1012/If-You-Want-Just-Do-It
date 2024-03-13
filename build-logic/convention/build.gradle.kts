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

        register("AndroidLibraryPlugin") {
            id = "if.plugin.library"
            implementationClass = "plugin.AndroidLibraryPlugin"
        }

        register("ComposePlugin") {
            id = "if.plugin.compose"
            implementationClass = "plugin.ComposePlugin"
        }

        register("HiltPlugin") {
            id = "if.plugin.hilt"
            implementationClass = "plugin.HiltPlugin"
        }
    }
}