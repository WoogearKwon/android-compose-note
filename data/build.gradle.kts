plugins {
    id(Plugins.Android.libraryGradle)
    id(Plugins.Kotlin.androidGradle)
    id(Plugins.Hilt.hiltGradle)
    id(Plugins.Kapt.kapt)
    id(Plugins.MapsSecret.mapsSecretGradle)
    id(Plugins.KotlinX.Serialization.serialization)
}

android {
    namespace = "com.woogear.data"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    kotlinOptions {
        jvmTarget = Config.javaVersion.toString()
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(platform(Libs.OkHttp3.bom))
    implementation(Libs.AndroidX.Core.coreKtx)
    implementation(Libs.AndroidX.Security.securityCrypto)
    implementation(Libs.Dagger.hiltAndroid)
    implementation(Libs.KotlinX.SerializationJson.serializationJson)
    implementation(Libs.OkHttp3.okhttp)
    implementation(Libs.OkHttp3.loggingInterceptor)
    implementation(Libs.Retrofit2.kotlinxSerializationConverter)
    implementation(Libs.Retrofit2.retrofit)

    kapt(Libs.Dagger.hiltCompiler)
}