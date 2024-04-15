plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.library.compose)
    alias(libs.plugins.ibrahimkurt.uiSetup)
}

android {
    namespace = "com.ibrahimkurt.core.component"

}

dependencies {
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.material3)
}