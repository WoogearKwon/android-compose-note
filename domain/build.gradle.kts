plugins {
    id("kotlin")
    id(Plugins.KotlinX.Serialization.serialization)
}

java {
    sourceCompatibility = Config.javaVersion
    targetCompatibility = Config.javaVersion
}

dependencies {
    implementation(Libs.KotlinX.SerializationJson.serializationJson)
    implementation(Libs.KotlinX.Coroutine.core)
}