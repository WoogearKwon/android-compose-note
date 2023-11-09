object Plugins {
    object Android {
        const val version = "7.4.2"

        const val applicationGradle = "com.android.application"
        const val libraryGradle = "com.android.library"
    }

    object GoogleServices {
        private const val version = "4.3.15"
        const val googleServices = "com.google.gms:google-services:$version"
        const val googleServicesGradle = "com.google.gms.google-services"
    }

    object Hilt {
        const val version = Libs.Dagger.version

        const val hiltGradle = "com.google.dagger.hilt.android"
        const val hiltAndgroidGradle = "com.google.dagger:hilt-android-gradle-plugin"
    }

    object Kapt {
        const val kapt = "kotlin-kapt"
    }

    object Kotlin {
        const val version = "1.8.10"

        const val androidGradle = "org.jetbrains.kotlin.android"
        const val parcelize = "kotlin-parcelize"
    }

    object KotlinX {
        object Serialization {
            const val version = Kotlin.version

            const val serialization = "kotlinx-serialization"
            const val serializationGradle = "org.jetbrains.kotlin.plugin.serialization"
        }
    }

    object MapsSecret {
        const val version = "2.0.1"
        const val mapsSecretGradle =
            "com.google.android.libraries.mapsplatform.secrets-gradle-plugin"
    }
}