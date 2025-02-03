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

package com.blacksquircle.ui.ds.slider

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.SliderDefaults.DisabledInactiveTrackAlpha
import androidx.compose.material.SliderDefaults.InactiveTrackAlpha
import androidx.compose.material.SliderDefaults.TickAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blacksquircle.ui.ds.SquircleTheme

@Composable
fun Slider(
    currentValue: Float,
    onValueChanged: (Float) -> Unit,
    modifier: Modifier = Modifier,
    displayCount: Boolean = true,
    enabled: Boolean = true,
    stepCount: Int = 1,
    minValue: Float = 0f,
    maxValue: Float = 1f,
) {
    var displayValueHolder by rememberSaveable { mutableFloatStateOf(currentValue) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier
                .requiredHeight(32.dp)
                .weight(1f)
        ) {
            Slider(
                value = displayValueHolder,
                valueRange = minValue..maxValue,
                steps = stepCount,
                onValueChange = { displayValueHolder = it },
                onValueChangeFinished = { onValueChanged(displayValueHolder) },
                enabled = enabled,
                colors = SliderDefaults.colors(
                    thumbColor = SquircleTheme.colors.colorPrimary,
                    disabledThumbColor = SquircleTheme.colors.colorBackgroundTertiary,
                    activeTrackColor = SquircleTheme.colors.colorPrimary,
                    inactiveTrackColor = SquircleTheme.colors.colorPrimary
                        .copy(alpha = InactiveTrackAlpha),
                    disabledActiveTrackColor = SquircleTheme.colors.colorBackgroundTertiary,
                    disabledInactiveTrackColor = SquircleTheme.colors.colorBackgroundTertiary
                        .copy(alpha = DisabledInactiveTrackAlpha),
                    activeTickColor = SquircleTheme.colors.colorPrimary,
                    inactiveTickColor = SquircleTheme.colors.colorPrimary
                        .copy(alpha = TickAlpha),
                    disabledActiveTickColor = SquircleTheme.colors.colorBackgroundTertiary,
                    disabledInactiveTickColor = SquircleTheme.colors.colorBackgroundTertiary,
                )
            )
        }
        if (displayCount) {
            Text(
                text = displayValueHolder.toInt().toString(),
                style = SquircleTheme.typography.text16Regular,
                color = if (enabled) {
                    SquircleTheme.colors.colorTextAndIconPrimary
                } else {
                    SquircleTheme.colors.colorTextAndIconDisabled
                },
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SliderEnabledPreview() {
    SquircleTheme {
        var currentValue by remember { mutableFloatStateOf(5f) }
        Slider(
            currentValue = currentValue,
            onValueChanged = { currentValue = it },
            enabled = true,
            minValue = 1f,
            maxValue = 10f,
            stepCount = 8,
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SliderDisabledPreview() {
    SquircleTheme {
        var currentValue by remember { mutableFloatStateOf(5f) }
        Slider(
            currentValue = currentValue,
            onValueChanged = { currentValue = it },
            enabled = false,
            minValue = 1f,
            maxValue = 10f,
            stepCount = 8,
        )
    }
}