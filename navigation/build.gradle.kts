plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.library.compose)

}

android {
    namespace = "com.ibrahimkurt.navigation"

}

dependencies {

    implementation(libs.androidx.navigation.compose)

    implementation(projects.features.home.ui)
    implementation(projects.features.home.data)
}