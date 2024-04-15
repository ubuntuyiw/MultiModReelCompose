import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.ibrahimkurt.convention.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.detekt.gradlePlugin)

}

gradlePlugin {
    plugins {
        register("androidCompose") {
            id = "ibrahimkurt.android.library.compose"
            implementationClass = "AndroidComposePlugin"
        }
        register("androidHilt") {
            id = "ibrahimkurt.android.hilt"
            implementationClass = "AndroidHiltPlugin"
        }
        register("androidLibrary") {
            id = "ibrahimkurt.android.library"
            implementationClass = "AndroidLibraryPlugin"
        }
        register("applicationCompose") {
            id = "ibrahimkurt.android.compose"
            implementationClass = "ApplicationComposePlugin"
        }
        register("application") {
            id = "ibrahimkurt.android.application"
            implementationClass = "ApplicationPlugin"
        }
        register("detekt") {
            id = "ibrahimkurt.detekt"
            implementationClass = "DetektPlugin"
        }
        register("jvmLibrary") {
            id = "ibrahimkurt.jvm.library"
            implementationClass = "JvmLibraryPlugin"
        }
        register("retrofitSerialization") {
            id = "ibrahimkurt.retrofit-serialization"
            implementationClass = "RetrofitSerializationPlugin"
        }
        register("UISetup") {
            id = "ibrahimkurt.android.ui-setup"
            implementationClass = "UISetupPlugin"
        }
    }
}