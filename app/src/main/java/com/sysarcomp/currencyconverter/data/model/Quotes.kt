package com.sysarcomp.currencyconverter.data.model

import com.google.gson.annotations.SerializedName

data class Quotes(
    @SerializedName("USDAUD") val USDAUD: Double,
    @SerializedName("USDEUR") val USDEUR: Double,
    @SerializedName("USDGBP") val USDGBP: Double,
    @SerializedName("USDARS") val USDAR: Double
)