plugins {
    id(Plugins.Android.applicationGradle)
    id(Plugins.Kotlin.androidGradle)
    id(Plugins.Hilt.hiltGradle)
    id(Plugins.Kapt.kapt)
}

android {
    namespace = "com.woogear.compose_note"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "com.woogear.compose_note"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.Compiler.version
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(Libs.AndroidX.Core.coreKtx)
    implementation(Libs.AndroidX.Lifecycle.lifecycleRuntimeKtx)
    implementation(Libs.AndroidX.Activity.activityCompose)
    implementation(Libs.AndroidX.Compose.Material.material)
    implementation(Libs.AndroidX.Compose.Ui.ui)
    implementation(Libs.AndroidX.Compose.Ui.uiToolingPreview)
    implementation(Libs.AndroidX.Compose.Ui.uiUtil)
    implementation(Libs.Coil.coilCompose)
    implementation(Libs.AndroidX.Navigation.navigationCompose)
    implementation(Libs.Dagger.hiltAndroid)
    implementation(Libs.AndroidX.Hilt.hiltNavigationCompose)
    kapt(Libs.Dagger.hiltCompiler)

    testImplementation(Libs.Junit.junit)
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.Espresso.espressoCore)
}