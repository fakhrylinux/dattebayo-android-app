plugins {
    alias(libs.plugins.android.dynamic.feature)
    alias(libs.plugins.jetbrains.kotlin.android)
}
apply("../shared_dependency.gradle")
android {
    namespace = "id.biz.equatron.dattebayo.favorite"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":app"))
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    implementation(libs.androidx.activity)
//    implementation(libs.androidx.constraintlayout)
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.fragment.ktx)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
}