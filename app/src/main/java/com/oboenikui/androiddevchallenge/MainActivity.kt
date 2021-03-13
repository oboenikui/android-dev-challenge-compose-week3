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
package com.oboenikui.androiddevchallenge

import android.R
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oboenikui.androiddevchallenge.ui.screen.HomeScreen
import com.oboenikui.androiddevchallenge.ui.screen.LoginScreen
import com.oboenikui.androiddevchallenge.ui.screen.WelcomeScreen
import com.oboenikui.androiddevchallenge.ui.theme.MyTheme
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val darkTheme = isSystemInDarkTheme()
            MyTheme(darkTheme) {
                MyApp(darkTheme)
            }
        }
        @Suppress("DEPRECATION")
        findViewById<View>(R.id.content).systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}

// Start building your app here!
@Composable
fun MyApp(darkTheme: Boolean = false) {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        NavHost(navController, startDestination = Screens.Welcome.route) {
            composable(Screens.Welcome.route) {
                WelcomeScreen(navController = navController, darkTheme)
            }
            composable(Screens.Login.route) {
                LoginScreen(navController = navController)
            }
            composable(Screens.Home.route) {
                HomeScreen()
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
