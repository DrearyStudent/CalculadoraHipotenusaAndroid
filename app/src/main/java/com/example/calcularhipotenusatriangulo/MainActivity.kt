package com.example.calcularhipotenusatriangulo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button

import android.widget.TextView

import android.widget.EditText
import android.widget.Toast
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.calcularhipotenusatriangulo.R.layout.activity_main)
        calcular = findViewById<View>(com.example.calcularhipotenusatriangulo.R.id.btnCalcular) as Button
        limpiar = findViewById<View>(com.example.calcularhipotenusatriangulo.R.id.btnLimpiar) as Button
        teA = findViewById<View>(com.example.calcularhipotenusatriangulo.R.id.edtxtA) as EditText
        teB = findViewById<View>(com.example.calcularhipotenusatriangulo.R.id.edtxtB) as EditText
        resultado = findViewById<View>(com.example.calcularhipotenusatriangulo.R.id.txtResultado) as TextView
        limpiar!!.setEnabled(false)

        teB!!.setText("")
        teA!!.setText("")

        calcular!!.setOnClickListener(View.OnClickListener {
            if (teA!!.text.toString().trim().isNullOrBlank()) {
                val mensaje = "Debe llenar todos los campos para continuar"
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            } else if (teB!!.text.toString().trim().isNullOrBlank()) {
                val mensaje = "Debe llenar todos los campos para continuar"
                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            } else {
                val cateto_a: String = teA!!.getText().toString()
                val cateto_b: String = teB!!.getText().toString()
                val a: Double = cateto_a!!.toDouble()
                val b: Double = cateto_b!!.toDouble()
                val r = Math.pow(Math.pow(a, 2.0) + Math.pow(b, 2.0), 0.5)
                respuesta = java.lang.String.valueOf(formato.format(r))
                if (r % 1.0 == 0.0) {
                    respuesta = r as String
                }
                resultado!!.text = "La hipotenusa es:  $respuesta"
                limpiar!!.isEnabled = true
                calcular!!.isEnabled = false
            }
        })

        limpiar!!.setOnClickListener(View.OnClickListener {
            limpiar_controles()
        })
    }
    var calcular: Button? = null
    var limpiar: Button? = null
    var resultado: TextView? = null
    var teA: EditText? = null
    var teB: EditText? = null
    var formato: DecimalFormat = DecimalFormat("#.00")
    var cateto_a: String? = null
    var cateto_b: String? = null
    var respuesta: String? = null

    fun limpiar_controles() {
        teB!!.setText("")
        teA!!.setText("")
        resultado!!.text = ""
        teA!!.requestFocus()
        limpiar!!.setEnabled(false)
        calcular!!.setEnabled(true)
    }
}