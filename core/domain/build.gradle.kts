plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
    alias(libs.plugins.ibrahimkurt.android.hilt)
}

android {
    namespace = "com.ibrahimkurt.core.domain"

}

dependencies {
    api(projects.core.common)

}