package plugin

import DependencyUnitValue
import com.android.build.api.dsl.LibraryExtension
import configure.configBasicOption
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

internal class AndroidFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("if.plugin.library")
                apply("if.plugin.library.compose")
                apply("if.plugin.hilt")
            }

            extensions.configure<LibraryExtension> {
                configBasicOption()

                defaultConfig {
                    consumerProguardFiles("consumer-rules.pro")
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }

            dependencies {
                DependencyUnitValue.implementation.run {
                    (project(":core:ui"))
                    (project(":core:designsystem"))
                    (project(":core:domain"))
                }
            }
        }
    }
}