package com.example.stethemquotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stethemquotes.data.Datasource
import com.example.stethemquotes.quote.Quote
import com.example.stethemquotes.ui.theme.StethemQuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StethemQuotesTheme {
                QuoteApp()
            }
        }
    }
}

@Composable
fun QuoteApp(modifier: Modifier = Modifier) {
    val quoteList = Datasource.loadStethemQuotes()
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        QuoteList(
            quoteList = quoteList,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun QuoteList(quoteList: List<Quote>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(quoteList) { quote ->
            QuoteCard(
                quote = quote,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun QuoteCard(quote: Quote, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(quote.quoteImageId),
                contentDescription = stringResource(quote.quoteTextId),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(192.dp)
            )
            Text(
                text = stringResource(quote.quoteTextId),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun QuoteCardPreview() {
    StethemQuotesTheme {
        QuoteCard(Quote(R.string.quote1, R.drawable.quote1))
    }
}

@Preview
@Composable
fun QuoteAppPreview() {
    StethemQuotesTheme {
        QuoteApp()
    }
}