package com.sysarcomp.currencyconverter.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sysarcomp.currencyconverter.ui.components.OptionsMenu
import com.sysarcomp.currencyconverter.ui.viewmodel.CurrencyViewmodel

@Composable
fun CurrencyScreen(currencyViewmodel: CurrencyViewmodel) {

    val currencyData by currencyViewmodel.currencyData.collectAsState()

    val selectedOption = remember { mutableStateOf("") }

    var amount by remember { mutableStateOf("") }

    var currencyFactor by remember { mutableStateOf("") }

    val maxDigits = 7

    LaunchedEffect(currencyData,selectedOption.value) {
        if (selectedOption.value.isNotEmpty()) {
            currencyViewmodel.fetchLiveExchangeRates(selectedOption.value)
        }
    }


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Text(text = "Currency converter", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = amount, onValueChange = {

                if (it.isEmpty()) {

                    amount = ""

                } else if (it.toDoubleOrNull() != null) {

                    amount = it
                }

            },
            placeholder = { Text(text = "USD") },
            singleLine = true
        )


        Spacer(modifier = Modifier.height(20.dp))

        OptionsMenu(option = selectedOption)

        Spacer(modifier = Modifier.height(20.dp))

        if (selectedOption.value.isNotEmpty() && currencyData != null) {

            when {

                selectedOption.value == "AUD" -> {

                    if (currencyData!!.quotes?.USDAUD != null) {

                        currencyFactor = currencyData!!.quotes.USDAUD.toString()

                        Text("Source: ${currencyData!!.quotes.USDAUD}")
                    }


                }

                selectedOption.value == "ARS" -> {

                    if (currencyData!!.quotes?.USDAR != null) {

                        currencyFactor = currencyData!!.quotes.USDAR.toString()
                        Text("Source: ${currencyData!!.quotes.USDAR}")
                    }
                }

                selectedOption.value == "EUR" -> {

                    if (currencyData!!.quotes?.USDAR != null) {

                        currencyFactor = currencyData!!.quotes.USDEUR.toString()

                        Text("Source: ${currencyData!!.quotes.USDEUR}")
                    }
                }

                selectedOption.value == "GBP" -> {

                    if (currencyData!!.quotes?.USDGBP != null) {

                        currencyFactor = currencyData!!.quotes.USDGBP.toString()

                        Text("Source: ${currencyData!!.quotes.USDGBP}")
                    }
                }

            }

            Log.i("patrox", currencyFactor)
            Log.i("patrox", selectedOption.value)

            Spacer(modifier = Modifier.height(20.dp))

            var result: Double? = null

            if (amount != "" && currencyFactor != "") {

                result = amount.toDouble() * currencyFactor.toDouble()

                val resultStr = String.format("%.3f", result)

                Text(text = resultStr + " " + selectedOption.value, fontSize = 40.sp)
            }


        } else {
            // Text("Loading exchange rates...")
        }
    }
}