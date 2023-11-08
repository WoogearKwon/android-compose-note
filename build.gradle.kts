buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Plugins.Hilt.hiltAndgroidGradle)
    }
}

plugins {
    id(Plugins.Android.applicationGradle) version Plugins.Android.version apply false
    id(Plugins.Android.libraryGradle)  version Plugins.Android.version apply false
    id(Plugins.Kotlin.androidGradle) version Plugins.Kotlin.version apply false
    id(Plugins.Hilt.hiltGradle) version Plugins.Hilt.version apply false
    id(Plugins.KotlinX.Serialization.serializationGradle) version Plugins.KotlinX.Serialization.version apply false
}