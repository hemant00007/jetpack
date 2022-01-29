package com.example.kotlin_jetpack.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin_jetpack.api.QuoteService
import com.example.kotlin_jetpack.db.QuoteDatabase
import com.example.kotlin_jetpack.models.Quotelist
import com.example.kotlin_jetpack.utils.NetworkUtils

class QuotesRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
   private val applicationContext: Context
//    variables defined with var are mutable(Read and Write) variables defined with val are immutable(Read only)
)
{

    private  val quotesLiveData = MutableLiveData<Quotelist>()
    val  quotes : LiveData<Quotelist>
    get() = quotesLiveData

    suspend fun getQuotes(page: Int){

        if (NetworkUtils.isInternetAvailable(applicationContext)){
            val result = quoteService.getQuotes(page)
            if (result?.body() != null){
               // quoteDatabase.queteDao().getDelete()
                quoteDatabase.queteDao().addQuotes(result.body()!!.results)
                quotesLiveData.postValue(result.body())
            }
        } else
        {
            val  quotes = quoteDatabase.queteDao().getQuotes()
            val quotelist = Quotelist(1,2,3,quotes,3,5)
            quotesLiveData.postValue(quotelist)
        }

    }

}