package plugin

import com.android.build.api.dsl.LibraryExtension
import configure.configBasicOption
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
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
                    (libs.findBundle("androidX").get())
                    (libs.findBundle("android.ktx").get())
                    (libs.findLibrary("kotlin.serialization").get())
                }

                DependencyUnitValue.testImplementation.run{
                    (libs.findLibrary("junit").get())
                }

                DependencyUnitValue.androidTestImplementation.run {
                    (libs.findBundle("test").get())
                }
            }
        }
    }
}