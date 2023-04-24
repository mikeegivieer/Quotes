package com.example.quotes.data.network

import com.example.quotes.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET
import java.net.ResponseCache

interface QuoteApiClient {
    @GET("/quotes.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}