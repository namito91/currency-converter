package com.sysarcomp.currencyconverter.data.repository

import com.sysarcomp.currencyconverter.data.model.CurrencyResponse
import com.sysarcomp.currencyconverter.data.remote.RetrofitInstance

class CurrencyRepository {

    private val api = RetrofitInstance.api

    suspend fun getLiveExchangeRates(
        accessKey: String,
        currencies: String
    ): CurrencyResponse? {

        val response = api.getLiveExchangeRates(accessKey, currencies)

        return if (response.isSuccessful) {
            response.body()
        } else {
            null // Maneja el error aquí según tus necesidades
        }
    }
}
