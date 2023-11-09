plugins {
    id("kotlin")
    id(Plugins.KotlinX.Serialization.serialization)
}

dependencies {
    implementation(Libs.KotlinX.SerializationJson.serializationJson)
    implementation(Libs.KotlinX.Coroutine.core)
}