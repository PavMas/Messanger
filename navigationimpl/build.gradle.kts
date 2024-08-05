import com.android.build.gradle.internal.utils.immutableMapBuilder

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("org.jetbrains.kotlin.kapt")
    id("androidx.navigation.safeargs.kotlin")
    id ("kotlin-kapt")
}

android {
    namespace = "com.trifcdr.navigationimpl"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

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
    kapt{
        correctErrorTypes = true

    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat.v160)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.androidx.navigation.fragment.ktx.v253)
    implementation(libs.androidx.navigation.ui.ktx.v253)
    implementation(libs.dagger)

    kapt(libs.dagger.compiler)
    annotationProcessor(libs.dagger.compiler)


    api(project(":navigationapi"))
    implementation(project(":di"))
    implementation(project(":Authorization"))
    implementation(project(":Registration"))

}