plugins {
    alias(libs.plugins.ibrahimkurt.jvm.library)
}

group = "com.ibrahimkurt.features.detail.domain"

dependencies {
    implementation(projects.core.domain)
    implementation(libs.javax.inject)
    implementation(libs.kotlinx.coroutines.core)
}