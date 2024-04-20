plugins {
    alias(libs.plugins.ibrahimkurt.jvm.library)
}

group = "com.ibrahimkurt.core.domain"

dependencies {
    api(projects.core.common)
    implementation(libs.javax.inject)
    implementation(libs.kotlinx.coroutines.core)


}