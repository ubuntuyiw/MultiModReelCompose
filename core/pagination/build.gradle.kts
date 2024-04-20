plugins {
    alias(libs.plugins.ibrahimkurt.jvm.library)
}

group = "com.ibrahimkurt.pagination"

dependencies {
    api(libs.kotlinx.paging3Common)
    implementation(projects.core.common)
}