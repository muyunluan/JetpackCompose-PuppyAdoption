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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

object DataProvider {

    val favoriteBreeds = listOf<Breed>(
        Breed(
            1,
            "All",
            "All",
            R.drawable.dog_paw
        ),
        Breed(
            2,
            "Pug",
            "The Pug is often described as a lot of dog in a small space. " +
                "These sturdy, compact dogs are a part of the " +
                "American Kennel Club’s Toy group, and are known as " +
                "the clowns of the canine world because they have a " +
                "great sense of humor and like to show off.",
            R.drawable.pug
        ),
        Breed(
            3,
            "Corgi Inu",
            "The Corgi Inu is a mixed breed dog — a cross between the Shiba Inu " +
                "and the Corgi dog breeds. With the adorable looks of a fox, " +
                "these vigilant, affable pups inherited some of the best qualities " +
                "from both of their parents.",
            R.drawable.corgi_inu
        ),
        Breed(
            4,
            "German Sheprador",
            "The German Sheprador is a mixed breed dog — a cross between " +
                "the German Shepherd and Labrador Retriever dog breeds. Large, " +
                "energetic, and loyal, these pups inherited some of the best qualities " +
                "from both of their parents.",
            R.drawable.german_sheprador
        ),
        Breed(
            5,
            "Alaskan Klee Kai",
            "Small, smart, and energetic, the Alaskan Klee Kai is a relatively " +
                "new breed that looks like a smaller version of the Siberian Husky. " +
                "Even the name \"Klee Kai\" comes from an Inuit term meaning \"small dog.\"",
            R.drawable.alaskan_klee_kai
        )
    )

    val allBreeds = listOf<Dog>(
        Dog(
            1,
            R.drawable.pug,
            "Dog 1",
            "Pug",
            "San Jose, CA",
            1,
            "Female",
            "Medium",
            "Vaccinations up to date"
        ),
        Dog(
            2,
            R.drawable.corgi_inu,
            "Dog 2",
            "Corgi Inu",
            "San Jose, CA",
            3,
            "Female",
            "Medium",
            "Vaccinations up to date"
        ),
        Dog(
            3,
            R.drawable.german_sheprador,
            "Dog 3",
            "German Sheprador",
            "San Jose, CA",
            1,
            "Female",
            "Medium",
            "Vaccinations up to date"
        ),
        Dog(
            4,
            R.drawable.alaskan_klee_kai,
            "Dog 4",
            "Alaskan Klee Kai",
            "San Jose, CA",
            1,
            "Female",
            "Medium",
            "Vaccinations up to date"
        ),
        Dog(
            5,
            R.drawable.dog,
            "Dog 5",
            "Pug",
            "San Jose, CA",
            2,
            "Female",
            "Medium",
            "Vaccinations up to date"
        )
    )

    val listOfPugs = listOf<Dog>(
        Dog(
            1,
            R.drawable.pug,
            "Dog 1",
            "Pug",
            "San Jose, CA",
            1,
            "Female",
            "Medium",
            "Vaccinations up to date"
        ),
        Dog(
            5,
            R.drawable.dog,
            "Dog 5",
            "Pug",
            "San Jose, CA",
            2,
            "Female",
            "Medium",
            "Vaccinations up to date"
        )
    )

    val listOfCorgiInu = listOf<Dog>(
        Dog(
            2,
            R.drawable.corgi_inu,
            "Dog 2",
            "Corgi Inu",
            "San Jose, CA",
            3,
            "Female",
            "Medium",
            "Vaccinations up to date"
        )
    )

    val listOfFavorites = listOf<List<Dog>>(
        listOfPugs,
        listOfCorgiInu
    )
}
