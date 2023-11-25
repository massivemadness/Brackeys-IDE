/*
 * Copyright 2023 Squircle CE contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("com.blacksquircle.common")
}

android {
    namespace = "com.blacksquircle.ui.ds"

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {

    // Core
    implementation(libs.androidx.splashscreen)

    // UI
    implementation(libs.androidx.appcompat)
    implementation(libs.materialdesign)
    implementation(libs.colorpicker)

    // Compose
    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    implementation(libs.compose.preview)
    debugImplementation(libs.compose.tooling)
    debugImplementation(libs.compose.manifest)

    // DI
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
}