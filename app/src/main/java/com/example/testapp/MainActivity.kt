package com.example.testapp

import kotlin.math.round
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fromSpinner: Spinner = findViewById(R.id.fromSpinner)
        fromSpinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this,
            R.array.currencies_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fromSpinner.adapter = adapter
        }
        val toSpinner: Spinner = findViewById(R.id.toSpinner)
        toSpinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            this,
            R.array.currencies_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            toSpinner.adapter = adapter
        }
        button.setOnClickListener {
            if (amountInput.text.toString().isEmpty()){
                val toast = Toast.makeText(applicationContext, "Вы не ввели сумму!", Toast.LENGTH_LONG)
                toast.show()
            }
            else {
                when (fromSpinner.selectedItem.toString()) {
                    "Доллар" -> {
                        val answer = JSONObject(DollarConversion().execute().get())
                        when (toSpinner.selectedItem.toString()) {
                            "Доллар" -> result.setText(
                                ((amountInput.text.toString().toDouble() * 1)
                                    .toString())
                            )
                            "Евро" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("EUR").toString()).toDouble()).toString())
                            )
                            "Рубль" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("RUB").toString()).toDouble()).toString())
                            )
                            "Фунт" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("GBP").toString()).toDouble()).toString())
                            )
                        }
                    }
                    "Рубль" -> {
                        val answer = JSONObject(RoubleConversion().execute().get())
                        when (toSpinner.selectedItem.toString()) {
                            "Рубль" -> result.setText(
                                ((amountInput.text.toString().toDouble() * 1)
                                    .toString())
                            )
                            "Евро" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("EUR").toString()).toDouble()).toString())
                            )
                            "Доллар" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("USD").toString()).toDouble()).toString())
                            )
                            "Фунт" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("GBP").toString()).toDouble()).toString())
                            )
                        }
                    }
                    "Евро" -> {
                        val answer = JSONObject(EuroConversion().execute().get())
                        when (toSpinner.selectedItem.toString()) {
                            "Евро" -> result.setText(
                                ((amountInput.text.toString().toDouble() * 1)
                                    .toString())
                            )
                            "Доллар" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("USD").toString()).toDouble()).toString())
                            )
                            "Рубль" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("RUB").toString()).toDouble()).toString())
                            )
                            "Фунт" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("GBP").toString()).toDouble()).toString())
                            )
                        }
                    }
                    "Фунт" -> {
                        val answer = JSONObject(PoundConversion().execute().get())
                        when (toSpinner.selectedItem.toString()) {
                            "Фунт" -> result.setText(
                                ((amountInput.text.toString().toDouble() * 1)
                                    .toString())
                            )
                            "Доллар" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("USD").toString()).toDouble()).toString())
                            )
                            "Рубль" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("RUB").toString()).toDouble()).toString())
                            )
                            "Евро" -> result.setText(
                                ((amountInput.text.toString().toDouble() *
                                        (answer.get("EUR").toString()).toDouble()).toString())
                            )

                        }
                    }
                }
            }
        }
    }


}
