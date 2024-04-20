plugins {
    alias(libs.plugins.ibrahimkurt.android.library)
}

android {
    namespace = "com.ibrahimkurt.pagination"
}

dependencies {
    implementation(libs.androidx.paging3)
    api(libs.androidx.paging3Common)
    implementation(projects.core.common)
}