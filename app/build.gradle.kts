plugins {
    alias(libs.plugins.ibrahimkurt.android.application)
    alias(libs.plugins.ibrahimkurt.android.compose)
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
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {


    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.material3)


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
}