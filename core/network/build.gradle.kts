import org.jetbrains.kotlin.konan.properties.Properties
plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.hilt)
    alias(libs.plugins.ibrahimkurt.android.retrofitSerialization)
}
val localProperties = Properties().apply {
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localPropertiesFile.reader().use { load(it) }
    }
}
val apiKey = localProperties.getProperty("API_KEY") ?: System.getenv("API_KEY")
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
    api(projects.core.common)
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chuckerNoOp)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation(libs.coil)
    implementation(libs.coilSvg)
}