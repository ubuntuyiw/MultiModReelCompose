plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.hilt)
    alias(libs.plugins.ibrahimkurt.android.retrofitSerialization)
}

android {
    namespace = "com.ibrahimkurt.features.detail.data"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.features.detail.domain)
}