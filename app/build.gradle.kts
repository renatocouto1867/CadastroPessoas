plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.cadastropessoas"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cadastropessoas"
        minSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("androidx.lifecycle:lifecycle-viewmodel:2.5.1")
    implementation("androidx.lifecycle:lifecycle-livedata:2.5.1")

    implementation("androidx.room:room-runtime:2.4.3")
    implementation("androidx.room:room-rxjava2:2.4.3")
    annotationProcessor("androidx.room:room-compiler:2.4.3")
    implementation ("androidx.cardview:cardview:1.0.0")

    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.7.0")
}