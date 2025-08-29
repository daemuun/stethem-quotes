package com.example.stethemquotes.quote

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Quote(
    @StringRes val quoteTextId: Int,
    @DrawableRes val quoteImageId: Int
)
