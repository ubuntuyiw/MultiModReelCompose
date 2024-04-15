plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.hilt)
    alias(libs.plugins.ibrahimkurt.android.retrofitSerialization)
}

android {
    namespace = "com.ibrahimkurt.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.common)
}