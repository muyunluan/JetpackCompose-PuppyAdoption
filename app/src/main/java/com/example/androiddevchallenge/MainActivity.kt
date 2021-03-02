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
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.commons.ContentListItem
import com.example.androiddevchallenge.commons.imageModifier
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme

const val SELECTED_DOG = "selected_dog"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                AdoptionHome()
            }
        }
    }
}

@Composable
fun AdoptionHome() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy Adoption") },
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface,
                elevation = 8.dp,
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_calendar_today_24),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_chat_bubble_24),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        content = {
            Column {
                FavoriteBreeds()
                Divider()
                SelectedBreed(DataProvider.allBreeds, LocalContext.current)
            }
        }
    )
}

@Composable
fun FavoriteBreeds() {
    val favorites = remember { DataProvider.favoriteBreeds }
    val selectedIndex = remember { mutableStateOf(0) }
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ScrollableTabRow(
            selectedTabIndex = selectedIndex.value,
            divider = {},
            edgePadding = 16.dp,
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            favorites.forEachIndexed { index, breed ->
                Tab(
                    selected = index == selectedIndex.value,
                    onClick = {
                        selectedIndex.value = index
                    }
                ) {
                    ContentListItem(imageModifier, breed)
                }
            }
        }
    }
}

@Composable
fun SelectedBreed(dogs: List<Dog>, context: Context) {
    LazyColumn {
        items(
            items = dogs,
            itemContent = {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable {
                            context.startActivity(
                                Intent(context, DogDetailsActivity::class.java).apply {
                                    putExtra(SELECTED_DOG, it)
                                }
                            )
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = it.imgageId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = imageModifier
                    )
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = it.name)
                        Text(text = it.location)
                    }
                }
            }
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        AdoptionHome()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        AdoptionHome()
    }
}
