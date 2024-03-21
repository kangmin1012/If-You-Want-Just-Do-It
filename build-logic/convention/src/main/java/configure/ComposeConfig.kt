package configure

import DependencyUnitValue
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType


internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.configComposeOption()

    commonExtension.apply {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        dependencies {
            DependencyUnitValue.implementation(libs.findLibrary("androidx.activity.compose").get())
            val composeBom = platform(libs.findLibrary("androidx.compose.bom").get())
            DependencyUnitValue.implementation(composeBom)
            DependencyUnitValue.implementation(libs.findBundle("compose").get())
            DependencyUnitValue.implementation(libs.findLibrary("compose.navigation").get())

            DependencyUnitValue.androidTestImplementation(composeBom)
        }
    }
}

private fun CommonExtension<*, *, *, *, *, *>.configComposeOption() {

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }

}