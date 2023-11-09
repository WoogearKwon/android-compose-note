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

    buildFeatures {
        buildConfig = false
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.Compiler.version
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(Libs.AndroidX.Activity.activityCompose)
    implementation(Libs.AndroidX.Core.coreKtx)
    implementation(Libs.AndroidX.Compose.Material.material)
    implementation(Libs.AndroidX.Compose.Ui.ui)
    implementation(Libs.AndroidX.Compose.Ui.uiToolingPreview)
    implementation(Libs.AndroidX.Compose.Ui.uiUtil)
    implementation(Libs.AndroidX.Lifecycle.lifecycleRuntimeKtx)
    implementation(Libs.AndroidX.Lifecycle.lifecycleRuntimeCompose)
    implementation(Libs.Coil.coilCompose)
    implementation(Libs.Dagger.hiltAndroid)
    implementation(Libs.Gson.gson)
    implementation(Libs.KotlinX.SerializationJson.serializationJson)
    kapt(Libs.Dagger.hiltCompiler)
}