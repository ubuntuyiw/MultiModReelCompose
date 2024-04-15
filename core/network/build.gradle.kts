plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.hilt)
    alias(libs.plugins.ibrahimkurt.retrofitSerialization)
}

android {
    namespace = "com.ibrahimkurt.core.network"

    buildFeatures {
        buildConfig = true

    }

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
        }
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
        }
    }
}

dependencies {

}