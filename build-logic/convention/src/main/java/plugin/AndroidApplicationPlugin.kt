package plugin

import DependencyUnitValue
import com.android.build.api.dsl.ApplicationExtension
import configure.application.configureApplicationBuildType
import configure.application.configureApplicationDefault
import configure.configBasicOption
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationPlugin: Plugin<Project> {
    override fun apply(target: Project) {

        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
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
                val composeBom = platform(libs.findLibrary("androidx.compose.bom").get())

                add(DependencyUnitValue.implementation, libs.findBundle("androidx"))
                add(DependencyUnitValue.implementation, libs.findBundle("android.ktx").get())
                add(DependencyUnitValue.implementation, composeBom)
                add(DependencyUnitValue.implementation, libs.findBundle("compose").get())

                add(DependencyUnitValue.testImplementation, libs.findLibrary("junit").get())

                add(DependencyUnitValue.androidTestImplementation, composeBom)
                add(DependencyUnitValue.androidTestImplementation, libs.findBundle("test").get())

                add(DependencyUnitValue.debugImplementation, libs.findBundle("debug.test").get())
            }
        }
    }
}