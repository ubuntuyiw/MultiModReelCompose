import org.jetbrains.kotlin.konan.properties.Properties
plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.hilt)
    alias(libs.plugins.ibrahimkurt.android.retrofitSerialization)
}
val apiKey: String = Properties().apply {
    rootProject.file("local.properties").reader().use { load(it) }
}.getProperty("API_KEY")!!
android {
    namespace = "com.ibrahimkurt.core.network"

    buildFeatures {
        buildConfig = true

    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "API_KEY", "\"$apiKey\"")
        }
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
            buildConfigField("String", "API_KEY", "\"$apiKey\"")
        }
    }
}

dependencies {
    implementation(projects.core.common)
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chuckerNoOp)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
}