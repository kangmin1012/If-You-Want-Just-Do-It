package configure.application

import com.android.build.api.dsl.ApplicationExtension

internal fun ApplicationExtension.configureApplicationBuildType() {
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