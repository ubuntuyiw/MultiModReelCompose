plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.library.compose)
    alias(libs.plugins.ibrahimkurt.android.uiSetup)
}

android {
    namespace = "com.ibrahimkurt.features.detail.ui"
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.features.detail.domain)
}