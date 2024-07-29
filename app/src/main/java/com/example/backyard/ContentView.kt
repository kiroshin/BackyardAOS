/*
 * ContentView.kt
 * Created by Kiro Shin <mulgom@gmail.com> on 2024.
 */

package com.example.backyard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentView() {
    val navController = rememberNavController()
    var searchText by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val searchHistory = remember { mutableStateListOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SearchBar(modifier = Modifier.fillMaxWidth(),
                query = searchText,
                onQueryChange = { searchText = it },
                onSearch = {
                    searchHistory.add(searchText)
                    active = false
                },
                active = active,
                onActiveChange = { active = it },
                placeholder = { Text(text = "Enter your query") },
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                },
                trailingIcon = {
                    if (!active) { return@SearchBar }
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        modifier = Modifier.clickable {
                            if (searchText.isNotEmpty()) {
                                searchText = ""
                            } else {
                                active = false
                            }
                        }
                    )
                }
            ) {
                searchHistory.forEach {
                    if (it.isNotEmpty()) {
                        Text(text = it)
                    }
                }
                Divider()
                Text(text = "clear all history",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        },
        content = {
            NavHost(navController = navController,
                startDestination = "home",
                modifier = Modifier.padding(it)
            ) {
                composable("home") { One() }
            }
        }
    )
}

@Composable
fun ContentList() {

}
