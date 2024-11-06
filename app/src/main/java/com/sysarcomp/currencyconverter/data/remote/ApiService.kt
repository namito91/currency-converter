package com.sysarcomp.currencyconverter.data.remote

import com.sysarcomp.currencyconverter.data.model.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("live")
    suspend fun getLiveExchangeRates(
        @Query("access_key") accessKey: String,
        @Query("currencies") currencies: String
    ): Response<CurrencyResponse>
}
