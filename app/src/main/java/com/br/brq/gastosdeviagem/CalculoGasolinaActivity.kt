package com.br.brq.gastosdeviagem

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_calculo_gasolina.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class CalculoGasolinaActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculo_gasolina)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        btnCalcular.setOnClickListener(this)
        entrarCombustivel.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btnCalcular) {
            calcular()
        }
    }

    private fun calcular() {
        if (validacaoOk()) {

            try {
                val distance = distanciaTotal.text.toString().toFloat()
                val price = precoR.text.toString().toFloat()
                val autonomy = autonomiaTotal.text.toString().toFloat()

                val valorTotal = (distance * price) / autonomy
                totalResultado.text = "R$ ${"%.2f".format(valorTotal)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(
                    this,
                    getString(R.string.notificacao_informe_valor_valido),
                    Toast.LENGTH_LONG
                ).show()
            }

        } else {
            Toast.makeText(this, getString(R.string.notificacao_insira_valores), Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun validacaoOk(): Boolean {
        return (distanciaTotal.text.toString() != "" && distanciaTotal.text.toString() != "0" && precoR.text.toString() != "0" && precoR.text.toString() != "" && autonomiaTotal.text.toString() != "" && autonomiaTotal.text.toString() != "0")
    }
}


