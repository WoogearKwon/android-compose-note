import org.gradle.api.JavaVersion

object Config {
    const val minSdk = 26
    const val compileSdk = 34
    const val targetSdk = 34
    const val versionName = "0.0.1"
    const val versionCode = 1

    val javaVersion = JavaVersion.VERSION_1_8
}