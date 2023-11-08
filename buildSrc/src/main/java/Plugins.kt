object Plugins {
    object Android {
        const val version = "7.4.2"

        const val applicationGradle = "com.android.application"
        const val libraryGradle = "com.android.library"
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
}