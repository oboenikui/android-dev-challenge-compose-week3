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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.oboenikui.androiddevchallenge.Screens
import com.oboenikui.androiddevchallenge.ui.theme.MyTheme
import com.oboenikui.androiddevchallenge.ui.theme.typography

@Composable
fun LoginScreen(navController: NavController, darkTheme: Boolean = false) {
    Login(
        darkTheme,
        onClickLogin = {
            navController.navigate(Screens.Home.route)
        }
    )
}

@Composable
private fun Login(darkTheme: Boolean = false, onClickLogin: () -> Unit = {}) {
    var loginId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Log in with email",
            style = typography.h1,
            modifier = Modifier.paddingFromBaseline(top = 184.dp, bottom = 8.dp),
        )
        OutlinedTextField(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = MaterialTheme.colors.onBackground,
                textColor = MaterialTheme.colors.onBackground,
                focusedBorderColor = MaterialTheme.colors.secondary,
                focusedLabelColor = MaterialTheme.colors.secondary,
            ),
            label = {
                Text(
                    "Email address",
                    style = typography.body1,
                )
            },
            value = loginId,
            onValueChange = { loginId = it },
        )
        OutlinedTextField(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = MaterialTheme.colors.onBackground,
                textColor = MaterialTheme.colors.onBackground,
                focusedBorderColor = MaterialTheme.colors.secondary,
                focusedLabelColor = MaterialTheme.colors.secondary,
            ),
            label = {
                Text(
                    "Password (8+ characters)",
                    style = typography.body1,
                )
            },
            value = password,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password = it },
        )
        Text(
            AnnotatedString.Builder("By clicking below, you agree to our ").apply {
                append(
                    AnnotatedString(
                        "Terms of Use",
                        spanStyle = SpanStyle(textDecoration = TextDecoration.Underline)
                    )
                )
                append(" and consent to our ")
                append(
                    AnnotatedString(
                        "Privacy Policy",
                        spanStyle = SpanStyle(textDecoration = TextDecoration.Underline)
                    )
                )
                append(".")
            }.toAnnotatedString(),
            style = typography.body2,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 16.dp),
            textAlign = TextAlign.Center,
        )
        Button(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            onClick = onClickLogin,
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onSecondary,
            )
        ) {

            Text(
                "Log in",
                style = typography.button,
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewLogin() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Login(false)
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewLogin() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            Login(false)
        }
    }
}
