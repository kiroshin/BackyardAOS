/*
 * UIBasicSearchBar.kt
 * Created by Kiro Shin <mulgom@gmail.com> on 2024.
 */

package com.example.backyard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UIBasicSearchBar() {
    var searchText by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val searchHistory = remember { mutableStateListOf("") }

    Column {

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
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon") },
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
            contentViews.filter {
                searchText.isNotEmpty() and it.second.lowercase().contains(searchText)
            }.forEach {
                Text(text = it.second,
                    modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            }
            Divider()
            Text(text = "현재는 검색 결과만 표시함",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }

        Text(text = "쿼리 결과나 히스토리를 설정할 수 있다.",
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }

}

