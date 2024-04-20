plugins {
    alias(libs.plugins.ibrahimkurt.jvm.library)

}
group = "com.ibrahimkurt.features.home.domain"


dependencies {
    implementation(projects.core.domain)
    implementation(libs.javax.inject)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.paging3Common)
}