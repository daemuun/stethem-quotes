package com.example.stethemquotes.data

import com.example.stethemquotes.R
import com.example.stethemquotes.quote.Quote

object Datasource {
    fun loadStethemQuotes(): List<Quote> {
        return listOf(
            Quote(R.string.quote1, R.drawable.quote1),
            Quote(R.string.quote2, R.drawable.quote2),
            Quote(R.string.quote3, R.drawable.quote3),
            Quote(R.string.quote4, R.drawable.quote4),
            Quote(R.string.quote5, R.drawable.quote5),
            Quote(R.string.quote6, R.drawable.quote6),
            Quote(R.string.quote7, R.drawable.quote7),
            Quote(R.string.quote8, R.drawable.quote8),
            Quote(R.string.quote9, R.drawable.quote9),
            Quote(R.string.quote10, R.drawable.quote10),
        )
    }
}