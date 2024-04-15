plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.library.compose)
    alias(libs.plugins.ibrahimkurt.uiSetup)
}

android {
    namespace = "com.ibrahimkurt.features.home.ui"
}

dependencies {
    implementation(projects.features.home.domain)
    implementation(projects.core.ui)
}