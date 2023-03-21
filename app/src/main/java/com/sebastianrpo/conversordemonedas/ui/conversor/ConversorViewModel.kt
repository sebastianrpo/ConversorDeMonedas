package com.sebastianrpo.conversordemonedas.ui.conversor

import androidx.lifecycle.ViewModel

class ConversorViewModel : ViewModel() {

    fun convertCurrency(divisaOrigen: String, divisaDestino: String, cantidad: Double): Double {
        var result = 0.0
        when (divisaOrigen) {
            "Pesos colombianos" -> {
                when (divisaDestino) {
                    "Pesos colombianos" -> {
                        result = cantidad

                    }
                    "Dólares" -> {
                        result = cantidad * 0.00021
                    }
                    "Libras esterlinas" -> {
                        result = cantidad * 0.00018
                    }
                }
            }
            "Dólares" -> {
                when (divisaDestino) {
                    "Pesos colombianos" -> {
                        result = cantidad * 4765.50
                    }
                    "Dólares" -> {
                        result = cantidad
                    }
                    "Libras esterlinas" -> {
                        result = cantidad * 0.82
                    }
                }
            }
            "Libras esterlinas" -> {
                when (divisaDestino) {
                    "Pesos colombianos" -> {
                        result = cantidad * 5791.85
                    }
                    "Dólares" -> {
                        result = cantidad * 1.22
                    }
                    "Libras esterlinas" -> {
                        result = cantidad
                    }
                }
            }
        }
        return result
    }
}