package com.sebastianrpo.conversordemonedas.ui.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.sebastianrpo.conversordemonedas.R
import com.sebastianrpo.conversordemonedas.databinding.ActivityConversorBinding

class ConversorActivity : AppCompatActivity() {
    private lateinit var conversorBinding: ActivityConversorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        conversorBinding = ActivityConversorBinding.inflate(layoutInflater)
        val view = conversorBinding.root
        setContentView(view)

        val elegirSpinner = conversorBinding.eligeDivisaSpinner
        val convertirSpinner = conversorBinding.divisaConvertirSpinner
        val lista = resources.getStringArray(R.array.Divisas)
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
        var posicionElegirSpinner = ""
        var posicionConvertirSpinner = ""
        val cantidadAConvertir = conversorBinding.cantidadConvertirEditText
        val cantidadConvertida = conversorBinding.cantidadConvertidaTextView
        var total = 0.0

        elegirSpinner.adapter = adapter
        convertirSpinner.adapter = adapter

        elegirSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                posicionElegirSpinner = lista[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@ConversorActivity,"Error al traer las divisas", Toast.LENGTH_LONG)
            }
        }

        convertirSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                posicionConvertirSpinner = lista[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@ConversorActivity,"Error al traer las divisas", Toast.LENGTH_LONG)
            }
        }

        conversorBinding.convertirButton.setOnClickListener{
            if (cantidadAConvertir.text!!.isNotEmpty()) {
                when (posicionElegirSpinner) {
                    "Pesos colombianos" -> {
                        when (posicionConvertirSpinner) {
                            "Pesos colombianos" -> {
                                cantidadConvertida.text = cantidadAConvertir.text
                            }
                            "Dólares" -> {
                                total = cantidadAConvertir.text.toString().toDouble() * 0.00021
                                cantidadConvertida.text = total.toString()
                            }
                            "Libras esterlinas" -> {
                                total = cantidadAConvertir.text.toString().toDouble() * 0.00018
                                cantidadConvertida.text = total.toString()
                            }
                        }
                    }

                    "Dólares" -> {
                        when (posicionConvertirSpinner) {
                            "Pesos colombianos" -> {
                                total = cantidadAConvertir.text.toString().toDouble() * 4765.50
                                cantidadConvertida.text = total.toString()
                            }
                            "Dólares" -> {
                                cantidadConvertida.text = cantidadAConvertir.text
                            }
                            "Libras esterlinas" -> {
                                total = cantidadAConvertir.text.toString().toDouble() * 0.82
                                cantidadConvertida.text = total.toString()
                            }
                        }
                    }

                    "Libras esterlinas" -> {
                        when (posicionConvertirSpinner) {
                            "Pesos colombianos" -> {
                                total = cantidadAConvertir.text.toString().toDouble() * 5791.85
                                cantidadConvertida.text = total.toString()
                            }
                            "Dólares" -> {
                                total = cantidadAConvertir.text.toString().toDouble() * 1.22
                                cantidadConvertida.text = total.toString()
                            }
                            "Libras esterlinas" -> {
                                cantidadConvertida.text = cantidadAConvertir.text
                                //Fin versión 1
                            }
                        }
                    }
                }
            }
    }
}
}