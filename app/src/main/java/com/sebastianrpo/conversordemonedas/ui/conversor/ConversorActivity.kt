package com.sebastianrpo.conversordemonedas.ui.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.sebastianrpo.conversordemonedas.R
import com.sebastianrpo.conversordemonedas.databinding.ActivityConversorBinding

class ConversorActivity : AppCompatActivity() {
    private lateinit var conversorBinding: ActivityConversorBinding
    private lateinit var conversorViewModel: ConversorViewModel
    private var posicionElegirSpinner = ""
    private var posicionConvertirSpinner = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        conversorBinding = ActivityConversorBinding.inflate(layoutInflater)
        conversorViewModel = ViewModelProvider(this)[ConversorViewModel::class.java]
        val view = conversorBinding.root
        setContentView(view)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.Divisas))
        conversorBinding.eligeDivisaSpinner.adapter = adapter
        conversorBinding.divisaConvertirSpinner.adapter = adapter

        conversorBinding.eligeDivisaSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                posicionElegirSpinner = resources.getStringArray(R.array.Divisas)[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(
                    this@ConversorActivity,
                    getString(R.string.error_divisas),
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        conversorBinding.divisaConvertirSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                posicionConvertirSpinner = resources.getStringArray(R.array.Divisas)[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(
                    this@ConversorActivity,
                    getString(R.string.error_divisas),
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        conversorBinding.convertirButton.setOnClickListener {
            if (conversorBinding.cantidadConvertirEditText.text!!.isNotEmpty()) {
                conversorBinding.cantidadConvertidaTextView.text = conversorViewModel.convertCurrency(posicionElegirSpinner,posicionConvertirSpinner,conversorBinding.cantidadConvertirEditText.text.toString().toDouble())
                    .toString()
            }
        }
    }
}