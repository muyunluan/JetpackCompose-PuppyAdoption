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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.commons.imageModifier
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme

class DogDetailsActivity : AppCompatActivity() {
    val dog by lazy {
        intent.getParcelableExtra(SELECTED_DOG) as Dog?
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                dog?.let {
                    DogDetails(it) {
                        onBackPressed()
                    }
                }
            }
        }
    }
}

@Composable
fun DogDetails(dog: Dog, onBack: () -> Unit) {
    print(dog.name)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = dog.name) },
                backgroundColor = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.onSurface,
                elevation = 8.dp,
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = dog.imgageId),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp, top = 8.dp)
                            .height(100.dp)
                            .width(100.dp)
                            .clip(CircleShape)
                            .border(
                                shape = CircleShape,
                                border = BorderStroke(
                                    width = 3.dp,
                                    color = Color.LightGray
                                )
                            )
                    )
                    Column(
                        modifier = Modifier
                            .padding(24.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = String.format("Age: %d", dog.age))
                        Text(text = dog.location)
                    }
                }
                Divider()
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = String.format("%s / %s / %s", dog.breed, dog.sex, dog.size),
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.body1
                    )
                }
                Divider()
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = dog.health,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun PreviewDogDetails() {
    val dog: Dog = DataProvider.listOfCorgiInu[0]
    DogDetails(dog = dog, onBack = { /*TODO*/ })
}
