package configure.application

import com.android.build.api.dsl.ApplicationExtension

internal fun ApplicationExtension.configureApplicationDefault() {
    defaultConfig {
        applicationId = "ifyouwant.justdo.it"
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
}