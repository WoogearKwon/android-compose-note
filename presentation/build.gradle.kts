plugins {
    id(Plugins.Android.libraryGradle)
    id(Plugins.Kotlin.androidGradle)
    id(Plugins.Hilt.hiltGradle)
    id(Plugins.Kapt.kapt)
    id(Plugins.KotlinX.Serialization.serialization)
}

android {
    namespace = "com.woogear.presentation"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = Config.javaVersion
        targetCompatibility = Config.javaVersion
    }
    kotlinOptions {
        jvmTarget = Config.javaVersion.toString()
    }

    buildFeatures {
        buildConfig = false
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.Compiler.version
    }
}

dependencies {

    implementation(Libs.AndroidX.Core.coreKtx)
    implementation(Libs.AndroidX.Compose.Material.material)
    implementation(Libs.Dagger.hiltAndroid)
    implementation(Libs.Gson.gson)
    implementation(Libs.KotlinX.SerializationJson.serializationJson)
    kapt(Libs.Dagger.hiltCompiler)

    testImplementation(Libs.Junit.junit)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.Espresso.espressoCore)
}