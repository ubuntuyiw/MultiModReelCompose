plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.hilt)
}

android {
    namespace = "com.ibrahimkurt.features.template.domain"
}

dependencies {
    implementation(projects.core.domain)
}