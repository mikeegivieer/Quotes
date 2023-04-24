package com.example.quotes.domain

import com.example.quotes.data.QuoteRepository
import com.example.quotes.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GetQuotesUseCaseTest {


    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository

    lateinit var getQuotesUseCase: GetQuotesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    @Test
    fun `when the api doesnt return anything then get values from database`() = runBlocking {
        //Given
        coEvery { quoteRepository.getAllQuotesFromDatabase() } returns emptyList()

        //When
        getQuotesUseCase()

        //Then
        coVerify(exactly = 1) { quoteRepository.getAllQuotesFromDatabase() }

    }


    @Test
    fun `when the api return something then get values from api`() = runBlocking {
        //Given
        val myList = listOf(Quote("Quote", "Author"))
        coEvery { quoteRepository.getAllQuotesFromApi() } returns myList

        //When
        val response = getQuotesUseCase()

        //Then
        coVerify (exactly = 1){ quoteRepository.clearQuotes() }
        coVerify (exactly = 1){ quoteRepository.insertQuotes(any()) }
        coVerify (exactly = 0){ quoteRepository.getAllQuotesFromDatabase() }
        assert(myList == response)


        //Then


    }

}