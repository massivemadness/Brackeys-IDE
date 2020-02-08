/*
 * Licensed to the Light Team Software (Light Team) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The Light Team licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lightteam.modpeide.internal.di

import com.lightteam.modpeide.internal.di.modules.editor.EditorActivityModule
import com.lightteam.modpeide.internal.di.modules.editor.EditorFragmentsProvider
import com.lightteam.modpeide.internal.di.modules.settings.SettingsActivityModule
import com.lightteam.modpeide.internal.di.modules.settings.SettingsFragmentsProvider
import com.lightteam.modpeide.ui.editor.activities.EditorActivity
import com.lightteam.modpeide.internal.di.scopes.PerActivity
import com.lightteam.modpeide.ui.settings.activities.SettingsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = [EditorActivityModule::class, EditorFragmentsProvider::class])
    abstract fun buildEditorActivity(): EditorActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [SettingsActivityModule::class, SettingsFragmentsProvider::class])
    abstract fun buildSettingsActivity(): SettingsActivity
}