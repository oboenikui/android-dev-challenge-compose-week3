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

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oboenikui.androiddevchallenge.model.Garden
import com.oboenikui.androiddevchallenge.model.Theme
import com.oboenikui.androiddevchallenge.ui.theme.MyTheme
import com.oboenikui.androiddevchallenge.ui.theme.borderColor
import com.oboenikui.androiddevchallenge.ui.theme.typography
import com.oboenikui.androiddevchallenge.week3.R
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun HomeScreen() {
    Home()
}

@Composable
private fun Home() {
    val themes = listOf(
        Theme(
            label = "Desert chic",
            imageUrl = "https://images.pexels.com/photos/2132227/pexels-photo-2132227.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
        ),
        Theme(
            label = "Tiny terrariums",
            imageUrl = "https://images.pexels.com/photos/1400375/pexels-photo-1400375.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260"
        ),
        Theme(
            label = "Jungle vibes",
            imageUrl = "https://images.pexels.com/photos/1407305/pexels-photo-1407305.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
        ),
        Theme(
            label = "Easy care",
            imageUrl = "https://images.pexels.com/photos/6208086/pexels-photo-6208086.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
        ),
        Theme(
            label = "Statements",
            imageUrl = "https://images.pexels.com/photos/3511755/pexels-photo-3511755.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"
        ),
    )
    val gardens = listOf(
        Garden(
            label = "Monstera",
            imageUrl = "https://images.pexels.com/photos/3097770/pexels-photo-3097770.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260",
            description = "This is a description",
        ),
        Garden(
            label = "Aglaonema",
            imageUrl = "https://images.pexels.com/photos/4751978/pexels-photo-4751978.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
            description = "This is a description",
        ),
        Garden(
            label = "Peace lily",
            imageUrl = "https://images.pexels.com/photos/4425201/pexels-photo-4425201.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            description = "This is a description",
        ),
        Garden(
            label = "Fiddle leaf tree",
            imageUrl = "https://images.pexels.com/photos/6208087/pexels-photo-6208087.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            description = "This is a description",
        ),
        Garden(
            label = "Snake plant",
            imageUrl = "https://images.pexels.com/photos/2123482/pexels-photo-2123482.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            description = "This is a description",
        ),
        Garden(
            label = "Pothos",
            imageUrl = "https://images.pexels.com/photos/1084199/pexels-photo-1084199.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            description = "This is a description",
        ),
    )
    Scaffold(
        bottomBar = {
            BottomNavigation(elevation = 16.dp, backgroundColor = MaterialTheme.colors.primary) {
                BottomNavigationItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_home),
                            contentDescription = "Home",
                        )
                    },
                    label = { Text(text = "Home") },
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_favorite_border),
                            contentDescription = "Favorites",
                        )
                    },
                    label = { Text(text = "Favorites") },
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_account_circle),
                            contentDescription = "Profile",
                        )
                    },
                    label = { Text(text = "Profile") },
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_shopping_cart),
                            contentDescription = "Cart",
                        )
                    },
                    label = { Text(text = "Cart") },
                )
            }
        },
    ) {
        var searchText by remember { mutableStateOf("") }
        Box(
            Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp)
        ) {
            LazyColumn {
                item {
                    Box(Modifier.padding(top = 96.dp))
                }
                item {
                    Text(
                        "Browse themes",
                        style = typography.h1,
                        modifier = Modifier
                            .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                            .padding(start = 16.dp, end = 16.dp),
                    )
                }
                item {
                    LazyRow {
                        item {
                            Box(Modifier.width(12.dp))
                        }
                        items(themes) { theme ->
                            Card(
                                modifier = Modifier
                                    .width(144.dp)
                                    .height(140.dp)
                                    .padding(bottom = 4.dp, start = 4.dp, end = 4.dp),
                                backgroundColor = MaterialTheme.colors.surface,
                                shape = MaterialTheme.shapes.small,
                                border = null,
                            ) {
                                Column(
                                    modifier = Modifier
                                        .clickable { },
                                    horizontalAlignment = Alignment.Start,
                                ) {

                                    CoilImage(
                                        modifier = Modifier
                                            .width(136.dp)
                                            .height(96.dp),
                                        data = theme.imageUrl,
                                        contentScale = ContentScale.Crop,
                                        contentDescription = null,
                                        onRequestCompleted = {
                                            Log.d("CoilImage", it.toString())
                                        },
                                        error = {
                                            it.throwable.printStackTrace()
                                        }
                                    )
                                    Text(
                                        modifier = Modifier
                                            .paddingFromBaseline(
                                                top = 24.dp,
                                                bottom = 16.dp
                                            )
                                            .padding(start = 16.dp),
                                        text = theme.label,
                                        style = MaterialTheme.typography.h2,
                                    )
                                }
                            }
                        }

                        item {
                            Box(Modifier.width(12.dp))
                        }
                    }
                }
                item {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        Text(
                            "Design your home garden",
                            style = typography.h1,
                            modifier = Modifier
                                .paddingFromBaseline(top = 36.dp, bottom = 8.dp),
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_filter_list),
                            contentDescription = null,
                            tint = MaterialTheme.colors.onSurface,
                            modifier = Modifier
                                .align(Alignment.BottomEnd),
                        )
                    }
                }
                items(gardens) { garden ->

                    var checked by remember { mutableStateOf(false) }
                    Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                        Card(
                            modifier = Modifier
                                .size(72.dp)
                                .padding(top = 8.dp, end = 8.dp),
                            shape = MaterialTheme.shapes.small,
                            elevation = 0.dp,
                        ) {
                            CoilImage(
                                modifier = Modifier.size(64.dp),
                                contentScale = ContentScale.Crop,
                                data = garden.imageUrl,
                                contentDescription = null
                            )
                        }
                        Box(
                            Modifier
                                .height(72.dp)
                                .fillMaxWidth(),
                        ) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.TopStart)
                                    .padding(start = 8.dp)
                                    .paddingFromBaseline(top = 32.dp),
                                text = garden.label,
                                style = MaterialTheme.typography.h2,
                            )
                            Text(
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .padding(start = 8.dp)
                                    .paddingFromBaseline(bottom = 24.dp),
                                text = garden.description,
                                style = MaterialTheme.typography.body1,
                            )
                            Checkbox(
                                modifier = Modifier
                                    .align(Alignment.CenterEnd),
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = MaterialTheme.colors.onSecondary
                                ),
                                checked = checked,
                                onCheckedChange = { checked = it },
                            )
                            Box(
                                modifier = Modifier
                                    .background(borderColor)
                                    .height(1.dp)
                                    .fillMaxWidth()
                                    .align(Alignment.BottomCenter)
                            )
                        }
                    }
                }
                item {
                    Box(Modifier.height(16.dp))
                }
            }

            Box(Modifier.padding(top = 32.dp, start = 16.dp, end = 16.dp)) {
                Box(
                    Modifier
                        .background(
                            MaterialTheme.colors.background,
                            shape = MaterialTheme.shapes.small,
                        )
                        .align(Alignment.BottomCenter)
                        .height(56.dp)
                        .fillMaxWidth()
                )
                OutlinedTextField(
                    modifier = Modifier
                        .height(64.dp) // OutlinedTextField inserts 8dp padding to top.
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        cursorColor = MaterialTheme.colors.onBackground,
                        textColor = MaterialTheme.colors.onBackground,
                        focusedBorderColor = MaterialTheme.colors.secondary,
                        focusedLabelColor = MaterialTheme.colors.secondary,
                        backgroundColor = MaterialTheme.colors.background,
                    ),
                    leadingIcon = {
                        Icon(
                            modifier = Modifier.size(18.dp),
                            painter = painterResource(R.drawable.ic_search),
                            contentDescription = null,
                        )
                    },
                    placeholder = { Text("Search", style = MaterialTheme.typography.body1) },
                    value = searchText,
                    onValueChange = { searchText = it },
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewHome() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Home()
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewHome() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            Home()
        }
    }
}
