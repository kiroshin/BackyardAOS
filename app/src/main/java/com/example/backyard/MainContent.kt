/*
 * MainContent.kt
 * Created by Kiro Shin <mulgom@gmail.com> on 2024.
 */

package com.example.backyard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@Composable
fun MainContent() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = {
            MainNav(navController = navController, modifier = Modifier.padding(it))
        }
    )
}

