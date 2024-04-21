plugins {
    alias(libs.plugins.ibrahimkurt.android.application)
    alias(libs.plugins.ibrahimkurt.android.compose)
    alias(libs.plugins.ibrahimkurt.android.uiSetup)

}

android {
    namespace = "com.ibrahimkurt.multimodreelcompose"

    defaultConfig {
        applicationId = "com.ibrahimkurt.multimodreelcompose"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.component)
    implementation(projects.navigation)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(projects.features.home.data)
    implementation(projects.features.detail.data)
    implementation(libs.coil)

}