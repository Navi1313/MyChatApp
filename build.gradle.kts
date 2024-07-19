@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // Kotlin Symbol Processor newly
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")

    // Dagger Hilt dependency
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.whatsapclone"
    compileSdk = 34



    defaultConfig {
        applicationId = "com.example.whatsapclone"
        minSdk = 24
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // For Controlling SystemUi  status bar color we will use this.
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.34.0")

    // Adding an dependency for navigation :->
    implementation ("androidx.navigation:navigation-compose:2.7.7")

    // Material Color
    implementation ("com.google.android.material:material:1.11.0")

    // Material Icon Library
    implementation("androidx.compose.material:material-icons-extended:1.6.6")

    // adding dependency related to navigation Using Hilt ViewModel
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // viewModel Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")


    //dagger + hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    ksp("com.google.dagger:hilt-android-compiler:2.51.1")

    ksp("androidx.room:room-compiler:2.6.1")

    // For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.51.1")
    kspAndroidTest ("com.google.dagger:hilt-compiler:2.51.1")

    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:2.51.1")
    kspTest ("com.google.dagger:hilt-compiler:2.51.1")

}