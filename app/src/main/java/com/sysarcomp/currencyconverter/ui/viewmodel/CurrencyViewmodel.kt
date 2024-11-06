package com.sysarcomp.currencyconverter.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sysarcomp.currencyconverter.data.model.CurrencyResponse
import com.sysarcomp.currencyconverter.data.repository.CurrencyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CurrencyViewmodel() : ViewModel() {

    val currencyRepository = CurrencyRepository()

    private val _currencyData = MutableStateFlow<CurrencyResponse?>(null)
    val currencyData: StateFlow<CurrencyResponse?> = _currencyData


    fun fetchLiveExchangeRates(currency: String) {
        viewModelScope.launch {
            val response = currencyRepository.getLiveExchangeRates(
                accessKey = "a96d638d6967b17307996111f816fd8d",
                currencies = currency
            )
            _currencyData.value = response
        }
    }
}