package com.andariadar.listjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andariadar.listjetpackcompose.data.Place
import com.andariadar.listjetpackcompose.ui.theme.ListJetpackComposeTheme

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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()) {
            PlaceImage(place.image)
            Text(
                text = place.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp))
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