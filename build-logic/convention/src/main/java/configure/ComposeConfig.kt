package configure

import com.android.build.api.dsl.CommonExtension

internal fun CommonExtension<*, *, *, *, *, *>.configComposeOption() {

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}