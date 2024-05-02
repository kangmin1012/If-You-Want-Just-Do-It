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

        register("AndroidApplicationComposePlugin") {
            id = "if.plugin.application.compose"
            implementationClass = "plugin.AndroidApplicationComposePlugin"
        }

        register("AndroidLibraryComposePlugin") {
            id = "if.plugin.library.compose"
            implementationClass = "plugin.AndroidLibraryComposePlugin"
        }

        register("AndroidFeaturePlugin") {
            id = "if.plugin.feature"
            implementationClass = "plugin.AndroidFeaturePlugin"
        }

        register("HiltPlugin") {
            id = "if.plugin.hilt"
            implementationClass = "plugin.HiltPlugin"
        }
    }
}