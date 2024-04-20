plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.library.compose)
    alias(libs.plugins.ibrahimkurt.android.uiSetup)
}

android {
    namespace = "com.ibrahimkurt.core.ui"
}

dependencies {
    implementation(projects.core.domain)
    api(projects.core.component)
    api(projects.core.common)
    implementation(libs.coil)
    implementation(libs.coilCompose)
}