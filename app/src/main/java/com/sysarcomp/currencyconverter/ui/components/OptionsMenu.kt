package com.sysarcomp.currencyconverter.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OptionsMenu(option: MutableState<String>) {

    var expanded by remember { mutableStateOf(false) }


    Box {

        // Botón de menú para activar el DropdownMenu
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Menu Options")
        }

        Button(onClick = { expanded = true }) {
            Text(text = "Convert to")
        }

        // Menú desplegable de opciones
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            } // Ocultar el menú cuando se hace clic fuera de él
        ) {

            DropdownMenuItem(
                text = { Text(text = "ars", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                onClick = {
                    option.value = "ARS"
                    expanded = false

                },
                modifier = Modifier.size(70.dp, 35.dp)
            )

            DropdownMenuItem(
                text = {
                    Text(
                        text = "aud",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                onClick = {
                    option.value = "AUD"
                    expanded = false

                },
                modifier = Modifier.size(70.dp, 35.dp)
            )

            DropdownMenuItem(
                text = {
                    Text(
                        text = "eur",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                onClick = {
                    option.value = "EUR"
                    expanded = false

                },
                modifier = Modifier.size(70.dp, 35.dp)
            )

            DropdownMenuItem(
                text = {
                    Text(
                        text = "gbp",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                },
                onClick = {
                    option.value = "GBP"
                    expanded = false

                },
                modifier = Modifier.size(70.dp, 35.dp)
            )

        }

    }


}
