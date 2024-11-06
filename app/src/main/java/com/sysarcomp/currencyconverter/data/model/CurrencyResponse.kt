package com.sysarcomp.currencyconverter.data.model

data class CurrencyResponse(
    val privacy: String,
    val quotes: Quotes,
    val source: String,
    val success: Boolean,
    val terms: String,
    val timestamp: Int
)