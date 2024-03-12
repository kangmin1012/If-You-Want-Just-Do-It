package plugin

import DependencyUnitValue
import com.android.build.api.dsl.ApplicationExtension
import configure.application.configureApplicationBuildType
import configure.application.configureApplicationDefault
import configure.configBasicOption
import configure.configComposeOption
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                namespace = "ifyouwant.justdo.it"

                configureApplicationDefault()
                configureApplicationBuildType()
                configBasicOption()

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
            }

            dependencies { // 의존성 library 세팅
                with(DependencyUnitValue.implementation) {
                    (libs.findBundle("androidX").get())
                    (libs.findBundle("android.ktx").get())
                }

                with(DependencyUnitValue.testImplementation) {
                    (libs.findLibrary("junit").get())
                }

                with(DependencyUnitValue.androidTestImplementation) {
                    (libs.findBundle("test").get())
                }

                with(DependencyUnitValue.debugImplementation) {
                    (libs.findBundle("debug.test").get())
                }
            }
        }
    }
}