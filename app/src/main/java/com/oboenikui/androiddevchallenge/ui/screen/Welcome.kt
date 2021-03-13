/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.oboenikui.androiddevchallenge.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.oboenikui.androiddevchallenge.Screens
import com.oboenikui.androiddevchallenge.ui.theme.MyTheme
import com.oboenikui.androiddevchallenge.ui.theme.darkOnSurface
import com.oboenikui.androiddevchallenge.ui.theme.lightSecondary
import com.oboenikui.androiddevchallenge.ui.theme.typography
import com.oboenikui.androiddevchallenge.week3.R

@Composable
fun WelcomeScreen(navController: NavController, darkTheme: Boolean) {
    Welcome(
        darkTheme = darkTheme,
        onLogin = {
            navController.navigate(Screens.Login.route)
        }
    )
}

@Composable
private fun Welcome(
    darkTheme: Boolean = false,
    onCreateAccount: () -> Unit = {},
    onLogin: () -> Unit = {},
) {
    val logo = painterResource(
        id = if (darkTheme) R.drawable.dark_logo else R.drawable.light_logo
    )
    val background = painterResource(
        id = if (darkTheme) R.drawable.dark_welcome_bg else R.drawable.light_welcome_bg
    )
    val illos = painterResource(
        id = if (darkTheme) R.drawable.dark_welcome_illos else R.drawable.light_welcome_illos
    )
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxSize()
    ) {
        Image(
            painter = background,
            contentDescription = "",
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                illos, "",
                modifier = Modifier
                    .padding(start = 88.dp, top = 72.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.CenterStart,
            )
            Image(
                logo, "",
                modifier = Modifier.padding(top = 48.dp),
            )
            Text(
                text = "Beautiful home garden solutions",
                style = typography.subtitle1,
                modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 40.dp),
            )
            Button(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                onClick = onCreateAccount,
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = MaterialTheme.colors.onSecondary,
                )
            ) {
                Text(
                    text = "Create account",
                    style = typography.button,
                )
            }
            Box(Modifier.height(8.dp))
            TextButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                shape = MaterialTheme.shapes.medium,
                onClick = onLogin,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = if (darkTheme) darkOnSurface else lightSecondary,
                )
            ) {
                Text(
                    text = "Log in",
                    style = typography.button,

                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewWelcome() {
    MyTheme {
        Welcome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewWelcome() {
    MyTheme(darkTheme = true) {
        Welcome(darkTheme = true)
    }
}
