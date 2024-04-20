plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.library.compose)
    alias(libs.plugins.ibrahimkurt.android.uiSetup)
}

android {
    namespace = "com.ibrahimkurt.features.home.ui"
}

dependencies {
    implementation(projects.core.ui)
    implementation(projects.features.home.domain)
    implementation(libs.androidx.paging3Compose)
}