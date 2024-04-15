plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.hilt)
    alias(libs.plugins.ibrahimkurt.retrofitSerialization)
}

android {
    namespace = "com.ibrahimkurt.features.home.data"
}

dependencies {
    implementation(projects.features.home.domain)
    implementation(projects.core.data)
}