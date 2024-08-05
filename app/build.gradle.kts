plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("kotlin-kapt")
}

android {
    namespace = "com.trifcdr.messanger"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.trifcdr.messanger"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        generateStubs = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.core.ktx.v190)
    implementation(libs.androidx.appcompat.v160)
    implementation(libs.material.v180)
    implementation(libs.androidx.constraintlayout)
    implementation("com.google.dagger:dagger:2.44")
    kapt("com.google.dagger:dagger-compiler:2.44")

    implementation(project(":di"))
    implementation(project(":navigationimpl"))
    implementation(project(":Authorization"))
//    implementation project(":feature2")
//    implementation project(":feature3")
}