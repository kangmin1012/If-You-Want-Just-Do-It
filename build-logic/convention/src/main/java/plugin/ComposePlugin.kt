package plugin

import DependencyUnitValue
import com.android.build.api.dsl.ApplicationExtension
import configure.configComposeOption
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            extensions.configure<ApplicationExtension> {
                configComposeOption()
            }

            dependencies { // 의존성 library 세팅
                DependencyUnitValue.implementation(libs.findLibrary("androidx.activity.compose").get())
                val composeBom = platform(libs.findLibrary("androidx.compose.bom").get())
                DependencyUnitValue.implementation(composeBom)
                DependencyUnitValue.implementation(libs.findBundle("compose").get())

                DependencyUnitValue.androidTestImplementation(composeBom)

            }
        }
    }
}