object Libs {

    object AndroidX {
        object Activity {
            private const val version = "1.6.1"

            const val activityCompose = "androidx.activity:activity-compose:$version"
        }

        object AppCompat {
            private const val version = "1.6.1"

            const val appCompat = "androidx.appcompat:appcompat:$version"
        }

        object Compose {
            private const val bomVersion = "2023.06.01"
            const val bom = "androidx.compose:compose-bom:$bomVersion"

            object Compiler {
                const val version = "1.4.3"
            }

            object Material {
                private const val version = "1.3.1"
                const val material = "androidx.compose.material:material:$version"
            }

            object Ui {
                const val ui = "androidx.compose.ui:ui"
                const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
                const val uiTooling = "androidx.compose.ui:ui-tooling"
                const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
                const val uiUtil = "androidx.compose.ui:ui-util"
            }
        }

        object Core {
            private const val version = "1.9.0"

            const val coreKtx = "androidx.core:core-ktx:$version"
        }

        object Hilt {
            private const val version = "1.0.0"

            const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$version"
        }

        object Lifecycle {
            private const val version = "2.6.2"

            const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val lifecycleRuntimeCompose =
                "androidx.lifecycle:lifecycle-runtime-compose:$version"
        }

        object Navigation {
            private const val version = "2.6.0"

            const val navigationCompose = "androidx.navigation:navigation-compose:$version"
        }

        object SavedState {
            private const val version = "1.2.0"

            const val savedStateKtx = "androidx.savedstate:savedstate-ktx:$version"
        }

        object Security {
            private const val version = "1.0.0"

            const val securityCrypto = "androidx.security:security-crypto:$version"
        }

        object Test {
            object Espresso {
                private const val version = "3.5.1"

                const val espressoCore = "androidx.test.espresso:espresso-core:$version"
            }

            object Ext {
                const val junit = "androidx.test.ext:junit:1.1.5"
            }
        }
    }

    object Coil {
        private const val version = "2.4.0"

        const val coilCompose = "io.coil-kt:coil-compose:$version"
    }

    object Dagger {
        const val version = "2.44.2"

        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:$version"
    }

    object DesugarJdk {
        private const val version = "1.1.6"

        const val desugarJdkLib = "com.android.tools:desugar_jdk_libs:$version"
    }

    object Firebase {
        private const val bomVersion = "32.0.0"
        const val bom = "com.google.firebase:firebase-bom:$bomVersion"

        const val analyticsKtx = "com.google.firebase:firebase-analytics-ktx"
        const val commonKtx = "com.google.firebase:firebase-common-ktx"
        const val crashlyticsKtx = "com.google.firebase:firebase-crashlytics-ktx"
        const val messaging = "com.google.firebase:firebase-messaging-ktx"
    }

    object Gson {
        private const val version = "2.10.1"

        const val gson = "com.google.code.gson:gson:$version"
    }

    object Junit {
        private const val version = "4.13.2"

        const val junit = "junit:junit:$version"
    }

    object KotlinX {
        object Coroutine {
            private const val version = "1.7.1"

            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }

        object SerializationJson {
            private const val version = "1.5.1"

            const val serializationJson =
                "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
        }
    }

    object Material {
        private const val version = "1.5.0"

        const val material = "com.google.android.material:material:$version"
    }

    object OkHttp3 {
        private const val version = "4.10.0"

        const val bom = "com.squareup.okhttp3:okhttp-bom:$version"

        const val okhttp = "com.squareup.okhttp3:okhttp"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object Retrofit2 {
        private const val version = "2.9.0"
        private const val serializationConverterVersion = "0.8.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val kotlinxSerializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$serializationConverterVersion"
    }

    object Timber {
        private const val version = "5.0.1"

        const val timber = "com.jakewharton.timber:timber:$version"
    }
}