package com.food.sellerapp.model

import androidx.annotation.DrawableRes

data class Menus(@DrawableRes val itemImageId: Int,
                 val item: String,
                 val category: String)
