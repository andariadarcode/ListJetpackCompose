package com.andariadar.listjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.andariadar.listjetpackcompose.data.DataGeneration
import com.andariadar.listjetpackcompose.ui.theme.ListJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListJetpackComposeTheme {
                MainContent()
            }
        }
    }

    @Composable
    fun MainContent() {
        Surface(color = MaterialTheme.colors.background) {
            PlacesList()
        }
    }

    @Composable
    fun PlacesList() {
        val places = remember { DataGeneration.placeList }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = places,
                itemContent = {
                    PlaceItem(place = it)
                })
        }
    }
}




