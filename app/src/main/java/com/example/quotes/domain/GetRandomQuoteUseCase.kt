package com.example.quotes.domain

import com.example.quotes.data.QuoteRepository
import com.example.quotes.data.model.QuoteModel
import com.example.quotes.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository

) {
    suspend operator fun invoke(): Quote? {
        val quotes  = repository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber: Int = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}