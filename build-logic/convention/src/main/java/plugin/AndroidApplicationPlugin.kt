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
            }

            dependencies { // 의존성 library 세팅
                add(DependencyUnitValue.IMPLEMENTATION, libs.findBundle("android.ktx").get())
            }
        }
    }
}