package com.andariadar.listjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andariadar.listjetpackcompose.data.DataGeneration
import com.andariadar.listjetpackcompose.data.Place
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
}

@Composable
fun MainContent() {
    Scaffold { PlacesList() }
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

@Composable
private fun PlaceImage(image: Int) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(100.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(CornerSize(16.dp)))
    )
}

@Composable
fun PlaceItem(place: Place) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp),
        shape = RoundedCornerShape(CornerSize(16.dp))
    ) {
        Row {
            PlaceImage(place.image)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = place.title, style = typography.h6)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlaceItemPreview() {
    ListJetpackComposeTheme {
        PlaceItem(Place(1, "Rome", R.drawable.rome))
    }
}
