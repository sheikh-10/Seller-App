package com.food.sellerapp.data

import com.food.sellerapp.R
import com.food.sellerapp.model.Menus

object Datasource {
    fun loadMenus(): List<Menus> {
        return listOf(
            Menus(itemImageId = R.drawable.bella, item = "Salads", category = "Yummy salads"),
            Menus(itemImageId = R.drawable.koda, item = "Sandwiches", category = "Sandwiches"),
            Menus(itemImageId = R.drawable.faye, item = "Fresh Bakery", category = "Bakery"),
            Menus(itemImageId = R.drawable.faye, item = "Fresh Bakery", category = "Bakery"),
            Menus(itemImageId = R.drawable.faye, item = "Fresh Bakery", category = "Bakery"),
            Menus(itemImageId = R.drawable.faye, item = "Fresh Bakery", category = "Bakery"),
            Menus(itemImageId = R.drawable.faye, item = "Fresh Bakery", category = "Bakery"),
            Menus(itemImageId = R.drawable.faye, item = "Fresh Bakery", category = "Bakery"),
        )
    }
}