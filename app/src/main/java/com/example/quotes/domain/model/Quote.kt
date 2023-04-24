package com.example.quotes.domain.model

import com.example.quotes.data.database.entities.QuoteEntity
import com.example.quotes.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)
