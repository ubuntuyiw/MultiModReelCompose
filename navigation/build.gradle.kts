plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.library.compose)
    alias(libs.plugins.ibrahimkurt.android.uiSetup)

}

android {
    namespace = "com.ibrahimkurt.navigation"

}

dependencies {

    implementation(libs.androidx.navigation.compose)
    implementation(projects.core.component)

    implementation(projects.features.home.ui)
    implementation(projects.features.detail.ui)
}