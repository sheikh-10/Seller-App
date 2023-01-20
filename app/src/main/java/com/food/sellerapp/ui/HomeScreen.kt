package com.food.sellerapp.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.icu.util.MeasureUnit
import android.view.Menu
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.food.sellerapp.R
import com.food.sellerapp.data.Datasource
import com.food.sellerapp.model.Menus
import com.food.sellerapp.ui.theme.SellerAppTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

        Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Outlined.Menu,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onSurface
                    )
            }

            Text(text = "Sellers app",
                style = MaterialTheme.typography.h6,
                modifier = modifier.weight(1f),
                color = MaterialTheme.colors.onSurface)

            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Outlined.ExitToApp,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onSurface)
            }
        }

        Text(text = "RESTAURANT INFO",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onSurface,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Column(modifier = modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Card(elevation = 2.dp,
                    shape = RoundedCornerShape(50),
                ) {

                    Text(text = "Ya Rahman",
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onSurface,
                        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
                Text(text = "test@test.com",
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface)

                Text(text = "Earnings: $54.0",
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface)

            }

            Image(painter = painterResource(id = R.drawable.bella),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(50))
            )
        }

        Divider(modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp))

        Text(
            text = "Menus",
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )

        MenusCardList()
    }
}

@Composable
private fun MenusCardList(modifier: Modifier = Modifier, menus: List<Menus> = Datasource.loadMenus()) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(menus) { it ->
            MenusCard(menus = it)
        }
    }
}

@Composable
private fun MenusCard(modifier: Modifier = Modifier, menus: Menus = Datasource.loadMenus()[0]) {
    Card(elevation = 4.dp, shape = RoundedCornerShape(20)) {
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {

            Image(painter = painterResource(id = menus.itemImageId),
                contentDescription = null,
                modifier = modifier
                    .clip(RoundedCornerShape(20))
                    .size(width = 100.dp, height = 80.dp),
                contentScale = ContentScale.Crop
                )

            Column(modifier = modifier.weight(1f)) {

                Text(text = menus.item,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface)

                Text(text = menus.category,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface)
            }


            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Outlined.Delete, contentDescription = null)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MenusCardLightThemePreview() {
    SellerAppTheme(darkTheme = false) {
        MenusCard()
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun MenusCardDarkThemePreview() {
    SellerAppTheme(darkTheme = true) {
        MenusCard()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenLightThemePreview() {
    SellerAppTheme(darkTheme = false) {
        HomeScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun HomeScreenDarkThemePreview() {
    SellerAppTheme(darkTheme = true) {
        HomeScreen()
    }
}