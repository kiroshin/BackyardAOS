/*
 * MainNav.kt
 * Created by Kiro Shin <mulgom@gmail.com> on 2024.
 */

package com.example.backyard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

val contentViews = listOf(
    Pair(20240801, "UIBasicSearchBar"),
)

@Composable
fun MainNav(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable("home") { LazyColumn {
            items(contentViews.sortedBy { it.second }) {
                Text(text = it.second,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate(it.second) }
                        .padding(vertical = 16.dp, horizontal = 8.dp)
                )
                Divider()
            }
        } }
        composable("UIBasicSearchBar") { UIBasicSearchBar() }
    }
}

