package com.sysarcomp.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sysarcomp.currencyconverter.data.repository.CurrencyRepository
import com.sysarcomp.currencyconverter.ui.screen.CurrencyScreen
import com.sysarcomp.currencyconverter.ui.theme.CurrencyConverterTheme
import com.sysarcomp.currencyconverter.ui.viewmodel.CurrencyViewmodel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            val currencyViewmodel: CurrencyViewmodel = viewModel()

            CurrencyConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Box(modifier = Modifier.padding(innerPadding)) {

                        CurrencyScreen(currencyViewmodel)
                    }

                }
            }
        }
    }
}

